package com.serma.fintechtestapp.presentation.best

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.serma.fintechtestapp.AppDevLife
import com.serma.fintechtestapp.presentation.base.BaseFragment
import com.serma.fintechtestapp.presentation.hot.HotViewModel

class BestFragment : BaseFragment() {

    override fun initDagger() {
        (requireActivity().application as AppDevLife).getAppComponent()
            .registerBestComponent()
            .create()
            .inject(this)
    }

    override fun initViewModule() {
        viewModel = ViewModelProvider(this, viewModelFactory)[BestViewModel::class.java]
    }

}