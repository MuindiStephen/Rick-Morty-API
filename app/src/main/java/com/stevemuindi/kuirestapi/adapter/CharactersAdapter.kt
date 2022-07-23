package com.stevemuindi.kuirestapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stevemuindi.kuirestapi.databinding.CharacterRowBinding
import com.stevemuindi.kuirestapi.model.Result


//instead of using RecycleView Adapter
//We will use the listAdapter which takes the result and viewHolder
class CharactersAdapter: ListAdapter<Result,CharactersAdapter.MyViewHolder>(MyDiffUtil){

    //DiffUtil -> Tracks changes made to the RecycleViewAdapter
    //calculate difference between 2 non-null items in a list
    //calculate difference between  two list items
    object MyDiffUtil: DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

    }

    inner class MyViewHolder(private val binding: CharacterRowBinding)
        :RecyclerView.ViewHolder(binding.root) //Returns outermost View in the associated layout.
    {
        fun bind(character: Result) {
            binding.characterTextView.text = character.name
            Glide.with(binding.characterImageView).load(character.image).into(binding.characterImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(CharacterRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
    }

}