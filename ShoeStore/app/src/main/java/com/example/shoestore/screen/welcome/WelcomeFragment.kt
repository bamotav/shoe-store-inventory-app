package com.example.shoestore.screen.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.shoestore.R
import com.example.shoestore.databinding.WelcomeFragmentBinding
import com.example.shoestore.screen.instructions.InstructionFragment
import com.example.shoestore.screen.instructions.InstructionViewModel


private const val NUM_PAGES = 4

class WelcomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewModel: WelcomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : WelcomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false)
        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        binding.welcomeViewModel = viewModel
        binding.lifecycleOwner = this
        viewPager = binding.pagerOnboarding


        viewPager.adapter = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                 return viewModel.screenItems.value!!.count()
            }
            override fun createFragment(position: Int): Fragment {
               return InstructionFragment(viewModel.screenItems.value!![position])
            }
        }

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        return binding.root

    }

//    private inner class ScreenInstructionPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
//
//        override fun getItemCount(): Int {
//           return NUM_PAGES
//        }
//
//        override fun createFragment(position: Int): Fragment {
//            TODO("Not yet implemented")
//        }
//
//    }

}