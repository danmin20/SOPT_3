package com.danmin.sopt_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        with(main_viewPager) {
            adapter = MainPageAdapter(supportFragmentManager)
            offscreenPageLimit = 3
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {

                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                }

                override fun onPageSelected(position: Int) {
                    nav_view.menu.getItem(position).isChecked = true
                }

            })

            nav_view.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_home -> main_viewPager.currentItem = 0
                    R.id.menu_book -> main_viewPager.currentItem = 1
                    R.id.menu_person -> main_viewPager.currentItem = 2
                }
                true
            }
        }
    }
}
