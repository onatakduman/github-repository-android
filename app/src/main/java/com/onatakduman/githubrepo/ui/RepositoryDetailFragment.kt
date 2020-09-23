package com.onatakduman.githubrepo.ui

import android.content.Context
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.onatakduman.githubrepo.R
import com.onatakduman.githubrepo.base.BaseFragment
import com.onatakduman.githubrepo.base.loadFromUrl
import com.onatakduman.githubrepo.databinding.FragmentRepositoryDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepositoryDetailFragment :
    BaseFragment<FragmentRepositoryDetailBinding>(R.layout.fragment_repository_detail) {

    private val viewModel: GithubViewModel by activityViewModels()
    private val args: RepositoryDetailFragmentArgs by navArgs()

    override fun initViews(view: View) {

    }

    override fun initListeners() {

    }

    override fun setupViews() {
        binding.textviewOwnerName.text = args.repository.owner.login
        binding.imageviewProfile.loadFromUrl(args.owner.avatar_url)
        binding.textviewStars.text = args.repository.stargazers_count.toString()
        binding.textviewWatchers.text = args.repository.watchers_count.toString()
        binding.textviewForks.text = args.repository.forks_count.toString()
        binding.textviewOpenIssues.text = args.repository.open_issues_count.toString()
    }

    override fun setupObservers() {

    }

}