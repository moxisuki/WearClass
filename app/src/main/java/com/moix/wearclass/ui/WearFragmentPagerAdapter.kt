package com.moix.wearclass.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.moix.wearclass.MainActivity


class WearFragmentPagerAdapter(fm: FragmentManager, listFragment: List<Fragment>?, activity: MainActivity) : FragmentStateAdapter(activity) {

    private var fragmentList: List<Fragment>? = null

    init {
        fragmentList = listFragment

    }
    override fun getItemCount(): Int {
        return fragmentList!!.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList?.get(position)!!
    }
}