package com.moix.wearclass

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.moix.wearclass.databinding.ActivityMainBinding
import com.moix.wearclass.ui.ConfigFragment
import com.moix.wearclass.ui.HomeFragment
import com.moix.wearclass.ui.TableFragment
import com.moix.wearclass.ui.WearFragmentPagerAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG: String = "WearClassLog"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val viewPager = binding.viewpager
        val indicator = binding.indicator

        val list = mutableListOf<Fragment>()
        list.add(HomeFragment())
        list.add(TableFragment())
        list.add(ConfigFragment())

        val wearFragmentPagerAdapter = WearFragmentPagerAdapter(supportFragmentManager, list, this)
        viewPager.adapter = wearFragmentPagerAdapter
        viewPager.currentItem = 0;
        viewPager.registerOnPageChangeCallback(callback)
        indicator.setDotsCount(wearFragmentPagerAdapter.itemCount, true)
        indicator.setOnDotClickListener { position -> viewPager.currentItem = position }

    }

    private fun initFragment(position: Int) {
        when (position) {
            0 -> {
                // Refresh Home
            }

            1 -> {
                // Table Title
                binding.titleMain.setTitle(getString(R.string.table_title))
            }

            2 -> {
                binding.titleMain.setTitle(getString(R.string.config_title))
                // Config Title
            }
        }
    }

    // 首页回调监听器
    private val callback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageScrolled(position: Int, offset: Float, offsetPx: Int) {
            binding.indicator.onPageScrolled(position, offset, offsetPx)
        }

        override fun onPageSelected(position: Int) {
            initFragment(position)
            binding.indicator.onPageSelected(position);
            Log.e(TAG, "onPageSelected: $position")
        }

        override fun onPageScrollStateChanged(state: Int) {
            binding.indicator.onPageScrollStateChanged(state)
        }
    }
}