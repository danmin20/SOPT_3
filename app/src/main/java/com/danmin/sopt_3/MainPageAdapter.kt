package com.danmin.sopt_3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.danmin.sopt_3.fragment.HomeFragment
import com.danmin.sopt_3.fragment.LibraryFragment
import com.danmin.sopt_3.fragment.MypageFragment

class MainPageAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> LibraryFragment()
            else -> MypageFragment()
        }
    }

    override fun getCount() = 3
}