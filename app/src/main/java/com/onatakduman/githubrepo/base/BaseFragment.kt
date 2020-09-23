package com.onatakduman.githubrepo.base


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<VDB : ViewDataBinding>(private val layoutId: Int) : Fragment(layoutId) {

    internal lateinit var binding: VDB

    protected abstract fun initViews(view: View)

    protected abstract fun initListeners()

    protected abstract fun setupViews()

    protected abstract fun setupObservers()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        initViews(binding.root)
        initListeners()
        setupViews()
        setupObservers()
        return binding.root
    }

}
