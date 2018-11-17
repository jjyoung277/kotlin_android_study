package com.example.mygallery

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class MyPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    private val items = ArrayList<Fragment>()

    override fun getItem(p0: Int): Fragment {
        return items[p0]
    }

    override fun getCount(): Int {
        return items.size
    }

    fun updateFragments(items: List<Fragment>) {
        this.items.addAll(items)
    }
}