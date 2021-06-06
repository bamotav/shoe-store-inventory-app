package com.example.shoestore.screen.shoes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shoestore.R
import com.example.shoestore.databinding.CardviewShoesBinding
import com.example.shoestore.screen.shoes.data.Shoe

class ShoesAdapter(private val onClick: (Shoe) -> Unit) : ListAdapter<Shoe,ShoesAdapter.ShoesViewHolder>(ShoesDiffCallback) {

    class ShoesViewHolder(
        private val itemBinding: CardviewShoesBinding,
        onClick: (Shoe) -> Unit):
        RecyclerView.ViewHolder(itemBinding.root.rootView)
    {

        private var currentShoe: Shoe? = null

        init {
            itemView.setOnClickListener{
                currentShoe?.let(onClick)
            }
        }

        fun Bind(shoe: Shoe){
            currentShoe = shoe

            itemBinding.txtViewName.text = shoe.name
            itemBinding.txtViewModel.text = shoe.model
            itemBinding.txtViewPrice.text = shoe.price.toString()
            itemBinding.imgProduct.setImageResource(shoe.shoeImg)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoesViewHolder {
        val binding: CardviewShoesBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.cardview_shoes, parent, false)
        return ShoesViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: ShoesViewHolder, position: Int) {
      val shoe = getItem(position)
        holder.Bind(shoe)
    }

}

object ShoesDiffCallback : DiffUtil.ItemCallback<Shoe>() {
    override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem.id == newItem.id
    }

}