package com.onatakduman.githubrepo.ui

import android.content.Context
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.onatakduman.githubrepo.R
import com.onatakduman.githubrepo.base.BaseFragment
import com.onatakduman.githubrepo.data.utils.Status
import com.onatakduman.githubrepo.databinding.FragmentRepositoryListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepositoryListFragment :
    BaseFragment<FragmentRepositoryListBinding>(R.layout.fragment_repository_list) {

    private val viewModel: GithubViewModel by activityViewModels()

    //    private lateinit var viewModel: GithubViewModel
    private lateinit var repositoryAdapter: RepositoryAdapter

    override fun initViews(view: View) {
        // ignore view
    }

    override fun initListeners() {
        binding.buttonSearch.setOnClickListener {
            viewModel.getUserRepos(
                binding.textinputUsername.editText!!.text!!.toString()
            )
        }
    }

    override fun setupViews() {
        repositoryAdapter = RepositoryAdapter(RepositoryItemListener {
            viewModel.selectedRepo.postValue(it.name)
            findNavController().navigate(
                RepositoryListFragmentDirections.actionRepositoryListFragmentToRepositoryDetailFragment(
                    it,
                    it.owner
                )
            )
        })
        binding.recyclerviewRepository.adapter = repositoryAdapter
    }

    override fun setupObservers() {
        viewModel.repos.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    repositoryAdapter.submitList(it.data)
                    Log.e("asd", it.data?.get(0)!!.name)
                }
                Status.ERROR -> {
                    Log.e("asd", it.message!!)
                }
                Status.LOADING -> {
                    Log.e("asd", "loading")
                }
            }
        })
    }

}