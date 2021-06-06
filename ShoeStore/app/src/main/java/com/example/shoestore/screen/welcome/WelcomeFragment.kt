package com.example.shoestore.screen.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.shoestore.R
import com.example.shoestore.databinding.WelcomeFragmentBinding
import com.example.shoestore.screen.instructions.InstructionFragment
import com.example.shoestore.screen.instructions.ScreenItem
import com.example.shoestore.screen.login.LoginFragmentDirections
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.time.Duration

class WelcomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewModel: WelcomeViewModel
    private  lateinit var binding : WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding  = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false)

        val titleLorem = getString(R.string.titleLorem)
        val descriptionLorem = getString(R.string.descriptionLorem)

        val viewModelFactory = WelcomeViewModelFactory(listOf(
            ScreenItem(titleLorem, descriptionLorem, R.drawable.shop_1),
            ScreenItem(titleLorem, descriptionLorem, R.drawable.shop_2),
            ScreenItem(titleLorem, descriptionLorem, R.drawable.shop_3),
            ScreenItem(titleLorem, descriptionLorem, R.drawable.shop_4),
            ScreenItem(titleLorem, descriptionLorem, R.drawable.shop_5)
        ))

        viewModel = ViewModelProvider(this, viewModelFactory).get(WelcomeViewModel::class.java)
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

        TabLayoutMediator(binding.tablayoutpager, viewPager) { tab, position ->
        }.attach()



        viewModel.nextEvent.observe(viewLifecycleOwner, Observer {
            if (it) {
                if (viewPager.currentItem < viewModel.screenItems.value!!.size )
                {
                    viewPager.currentItem++
                }

                if (viewPager.currentItem == viewModel.screenItems.value!!.size - 1){
                    loadLastScreen()
                }
            }
        })

        viewModel.getStartedEvent.observe(viewLifecycleOwner, {
             if (it){
                 findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToShoesListFragment())
             }
        })

        binding.tablayoutpager.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {

                if (viewPager.currentItem == viewModel.screenItems.value!!.size - 1){

                    loadLastScreen()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        //viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        //(activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        return binding.root

    }

    fun loadLastScreen(){
        binding.btnGetStarted.visibility = View.VISIBLE
        binding.tablayoutpager.visibility = View.INVISIBLE
        binding.btnNext.visibility = View.INVISIBLE
        binding.btnGetStarted.let {

            it.alpha = 0f
            it.translationY = -100f

            it.animate().alpha(1f).translationY(0f).setDuration(1200)
        }
    }


}