package com.example.shoestore.screen.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.InstructionFragmentBinding
import com.example.shoestore.databinding.LoginFragmentBinding
import com.example.shoestore.screen.login.LoginViewModel


class InstructionFragment(val screenItem: ScreenItem) : Fragment() {

    private lateinit var viewModel: InstructionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModelFactory = InstructionViewModelFactory(screenItem)

        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.instruction_fragment, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(InstructionViewModel::class.java)

        binding.instructorViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.screenItem.value?.let { binding.introImage.setImageResource(it.screenImg) }


        //Hide toolbar when the app is in the Welcome, instruction page
       // (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        return binding.root

    }

}