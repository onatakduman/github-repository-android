package com.onatakduman.githubrepo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onatakduman.githubrepo.data.remote.model.Repository
import com.onatakduman.githubrepo.databinding.ListObjectRepositoryBinding

class RepositoryAdapter(private val clickListener: RepositoryItemListener) : ListAdapter<Repository,
        RepositoryAdapter.ViewHolder>(
    RepositoryDiffCallback()
) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    class ViewHolder private constructor(val binding: ListObjectRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Repository, clickListener: RepositoryItemListener) {
            binding.repository = item
            binding.onClickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListObjectRepositoryBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }

    }

}

class RepositoryDiffCallback : DiffUtil.ItemCallback<Repository>() {
    override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
        return oldItem == newItem
    }
}

class RepositoryItemListener(val clickListener: (repository: Repository) -> Unit) {
    fun onClick(repository: Repository) = clickListener(repository)
}
