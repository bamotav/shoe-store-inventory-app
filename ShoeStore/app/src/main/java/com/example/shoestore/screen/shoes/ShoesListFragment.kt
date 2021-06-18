package com.example.shoestore.screen.shoes

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.shoestore.R
import com.example.shoestore.databinding.ShoesListFragmentBinding
import com.example.shoestore.screen.shoes.data.Shoe


class ShoesListFragment : Fragment() {

    private lateinit var viewModel: ShoesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModelFactory = ShoeListViewModelFactory(requireContext())

        val binding: ShoesListFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.shoes_list_fragment, container, false)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ShoesListViewModel::class.java)

        binding.lifecycleOwner = this

        val shoeAdapter = ShoesAdapter(this::adapterOnClick)

        binding.recyclerViewShoesList.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerViewShoesList.adapter = shoeAdapter

        viewModel.shoesLiveData.observe(viewLifecycleOwner,{
            it?.let {
                shoeAdapter.submitList(it as MutableList<Shoe>)
            }
        })

        setHasOptionsMenu(true)

        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.topAppBar)

        return binding.root
    }

    private fun adapterOnClick(shoe: Shoe){

        view?.findNavController()
            ?.navigate(ShoesListFragmentDirections
                .actionShoesListFragmentToDetailShoesFragment(shoe.model, shoe.name, shoe.description, shoe.price.toFloat(), shoe.shoeImg))

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.top_app_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
                R.id.favorite ->{
                    true
                }

                R.id.search ->{
                    true
                }
                else -> false
            }
        return super.onOptionsItemSelected(item)
    }

    private fun showSystemUI() {
        val activity = activity as AppCompatActivity?
        if (activity != null) {

            activity.window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)

            //activity.supportActionBar!!.show()

        }
    }


}