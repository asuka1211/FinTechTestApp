package com.serma.fintechtestapp.presentation.random

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.serma.fintechtestapp.AppDevLife
import com.serma.fintechtestapp.presentation.base.BaseFragment
import com.serma.fintechtestapp.presentation.latest.LatestViewModel

class RandomFragment: BaseFragment() {
    override fun initDagger() {
        (requireActivity().application as AppDevLife).getAppComponent()
            .registerRandomComponent()
            .create()
            .inject(this)
    }

    override fun initViewModule() {
        viewModel = ViewModelProvider(this, viewModelFactory)[RandomViewModel::class.java]
    }
}