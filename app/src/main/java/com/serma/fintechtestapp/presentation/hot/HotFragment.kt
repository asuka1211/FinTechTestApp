package com.serma.fintechtestapp.presentation.hot

import androidx.lifecycle.ViewModelProvider
import com.serma.fintechtestapp.AppDevLife
import com.serma.fintechtestapp.presentation.base.BaseFragment

class HotFragment: BaseFragment(){

    override fun initDagger() {
        (requireActivity().application as AppDevLife).getAppComponent()
            .registerHotComponent()
            .create()
            .inject(this)
    }

    override fun initViewModule() {
        viewModel = ViewModelProvider(this, viewModelFactory)[HotViewModel::class.java]
    }

}