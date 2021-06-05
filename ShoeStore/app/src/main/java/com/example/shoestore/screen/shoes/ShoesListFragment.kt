package com.example.shoestore.screen.shoes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoesListFragmentBinding
import com.example.shoestore.screen.shoes.data.Shoe

class ShoesListFragment : Fragment() {

    private lateinit var viewModel: ShoesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: ShoesListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.shoes_list_fragment, container, false)
        viewModel = ViewModelProvider(this).get(ShoesListViewModel::class.java)

        binding.lifecycleOwner = this

        val shoeAdapter = ShoesAdapter(this::adapterOnClick)

        binding.recyclerViewShoesList.adapter = shoeAdapter

        //shoeAdapter.submitList()

        return binding.root
    }

    private fun adapterOnClick(shoe: Shoe){
        //TODO : go to detail

    }


}