package com.ekachandra.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ekachandra.core.databinding.ItemLoanBinding
import com.ekachandra.core.domain.model.Loan

class LoanAdapter : ListAdapter<Loan, LoanAdapter.ListViewHolder>(DIFF_CALLBACK) {

    var onItemClick: ((Loan) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoanAdapter.ListViewHolder {
        val binding = ItemLoanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LoanAdapter.ListViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    inner class ListViewHolder(private val binding: ItemLoanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Loan) {
            binding.tvBorrowerName.text = data.borrowerName
            binding.tvLoanAmount.text = data.loanAmount.toString()
        }

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedItem = getItem(position)
                    onItemClick?.invoke(clickedItem)
                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Loan>() {
            override fun areItemsTheSame(oldItem: Loan, newItem: Loan): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Loan, newItem: Loan): Boolean {
                return oldItem == newItem
            }
        }
    }
}


