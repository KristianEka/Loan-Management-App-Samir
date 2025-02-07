package com.ekachandra.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ekachandra.core.BuildConfig
import com.ekachandra.core.data.source.remote.response.DocumentsItem
import com.ekachandra.core.databinding.ItemDocumentBinding

class DocumentAdapter : ListAdapter<DocumentsItem, DocumentAdapter.ListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DocumentAdapter.ListViewHolder {
        val binding =
            ItemDocumentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DocumentAdapter.ListViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    inner class ListViewHolder(private val binding: ItemDocumentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DocumentsItem) {
            binding.apply {
                tvDocumentType.text = data.type
                ivDocument.contentDescription = data.type
                Glide.with(root)
                    .load("${BuildConfig.BASE_URL}${data.url}")
                    .into(ivDocument)

            }
        }

    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DocumentsItem>() {
            override fun areItemsTheSame(
                oldItem: DocumentsItem,
                newItem: DocumentsItem
            ): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(
                oldItem: DocumentsItem,
                newItem: DocumentsItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}