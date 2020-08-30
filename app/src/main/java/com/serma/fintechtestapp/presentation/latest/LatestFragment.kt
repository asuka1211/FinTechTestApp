package com.serma.fintechtestapp.presentation.latest

import androidx.lifecycle.ViewModelProvider
import com.serma.fintechtestapp.AppDevLife
import com.serma.fintechtestapp.presentation.base.BaseFragment


class LatestFragment : BaseFragment() {

    override fun initDagger() {
        (requireActivity().application as AppDevLife).getAppComponent()
            .registerLatestComponent()
            .create()
            .inject(this)
    }

    override fun initViewModule() {
        viewModel = ViewModelProvider(this, viewModelFactory)[LatestViewModel::class.java]
    }
}