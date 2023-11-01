package com.example.quoteapps.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapps.databinding.QuoteItemBinding
import com.example.quoteapps.model.Quote

class QuoteAdapter : ListAdapter<Quote, QuoteAdapter.QuoteViewHolder>(ComparatorDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val binding = QuoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val quote = getItem(position)
        quote?.let {
            holder.bind(it)
        }
    }

    class QuoteViewHolder(private val binding: QuoteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(quote: Quote) {
            binding.authorTv.text = quote.author
            binding.contentTv.text = quote.content

            binding.root.setOnClickListener {

            }
        }

    }

    class ComparatorDiffUtil : DiffUtil.ItemCallback<Quote>() {
        override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return oldItem == newItem
        }
    }


}