package com.moix.wearclass

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.moix.wearclass.data.AppViewModel
import com.moix.wearclass.data.LessonEntity
import com.moix.wearclass.data.TableList
import com.moix.wearclass.databinding.ActivityMainBinding
import com.moix.wearclass.databinding.FragmentConfigBinding
import com.moix.wearclass.ui.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG: String = WearApplication.TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val appViewModel = AppViewModel(this.application)
        initView(appViewModel)


    }

    private fun initView(appViewModel:AppViewModel) {
        val viewPager = binding.viewpager
        val indicator = binding.indicator

        // fragment
        val list = mutableListOf<Fragment>()
        list.add(HomeFragment())
        list.add(TableFragment())
        list.add(ConfigFragment(appViewModel))

        // 指示器
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