package com.example.shoestore.screen.shoes.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.DetailShoesFragmentBinding
import com.example.shoestore.screen.instructions.ScreenItem
import com.example.shoestore.screen.shoes.data.Shoe
import com.example.shoestore.screen.welcome.WelcomeViewModel
import com.example.shoestore.screen.welcome.WelcomeViewModelFactory

class DetailShoesFragment : Fragment() {


    private lateinit var viewModel: DetailShoesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: DetailShoesFragmentBinding =  DataBindingUtil.inflate(inflater, R.layout.detail_shoes_fragment, container, false)

        val args  = DetailShoesFragmentArgs.fromBundle(requireArguments())
        val viewModelFactory = DetailShoesModelFactory(Shoe(1, args.model, args.name, args.description, args.image, args.price.toDouble(),"" ))



        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailShoesViewModel::class.java)
        binding.detailShoesViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.image.observe(viewLifecycleOwner, Observer {

            binding.imgProduct.setImageResource(it)
        })

        binding.btnCancel.setOnClickListener {
            it.findNavController().popBackStack()
        }


        return binding.root
    }

}