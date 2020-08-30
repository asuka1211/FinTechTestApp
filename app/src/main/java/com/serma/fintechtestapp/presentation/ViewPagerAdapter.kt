package com.serma.fintechtestapp.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.serma.fintechtestapp.presentation.best.BestFragment
import com.serma.fintechtestapp.presentation.hot.HotFragment
import com.serma.fintechtestapp.presentation.latest.LatestFragment
import com.serma.fintechtestapp.presentation.random.RandomFragment

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {


    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return getFragment(position)
    }

    private fun getFragment(position: Int): Fragment {
        return when (position) {
            0 -> LatestFragment()
            1 -> BestFragment()
            2 -> HotFragment()
            3 -> RandomFragment()
            else -> LatestFragment()
        }
    }


}

