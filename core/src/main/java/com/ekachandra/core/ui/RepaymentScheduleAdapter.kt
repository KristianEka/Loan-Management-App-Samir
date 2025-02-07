package com.ekachandra.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ekachandra.core.R
import com.ekachandra.core.data.source.remote.response.InstallmentsItem
import com.ekachandra.core.databinding.ItemRepaymentScheduleBinding

class RepaymentScheduleAdapter :
    ListAdapter<InstallmentsItem, RepaymentScheduleAdapter.ListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepaymentScheduleAdapter.ListViewHolder {
        val binding =
            ItemRepaymentScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepaymentScheduleAdapter.ListViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    inner class ListViewHolder(private val binding: ItemRepaymentScheduleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: InstallmentsItem) {
            binding.apply {
                tvRepaymentScheduleDueDate.text = data.dueDate
                tvRepaymentScheduleAmountDue.text =
                    root.context.getString(R.string.loan_amount, data.amountDue)
            }
        }

    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<InstallmentsItem>() {
            override fun areItemsTheSame(
                oldItem: InstallmentsItem,
                newItem: InstallmentsItem
            ): Boolean {
                return oldItem.dueDate == newItem.dueDate
            }

            override fun areContentsTheSame(
                oldItem: InstallmentsItem,
                newItem: InstallmentsItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}