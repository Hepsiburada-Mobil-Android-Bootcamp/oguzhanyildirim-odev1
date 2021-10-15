package com.android.figmahomework.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.android.figmahomework.databinding.ActivityHomeBinding
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer

import androidx.recyclerview.widget.LinearLayoutManager
import com.android.figmahomework.data.model.HomeItemModel
import com.android.figmahomework.adapter.HorizontalMenuAdapter
import com.android.figmahomework.adapter.MovieViewPagerAdapter
import com.android.figmahomework.R
import com.android.figmahomework.data.model.MenuItemModel


class HomeActivity : AppCompatActivity() {

    private var homeItems = arrayListOf<HomeItemModel>()
    private var menuItems = arrayListOf<MenuItemModel>()
    private var binding : ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        generateData()

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding?.rvTopMenu?.layoutManager = layoutManager
        val horizontalMenuAdapter = HorizontalMenuAdapter(menuItems)
        binding?.rvTopMenu?.adapter = horizontalMenuAdapter


        binding?.let { b ->
            b.vpViewPager.apply {
                adapter = MovieViewPagerAdapter(applicationContext, homeItems) {
                    val intent = Intent(applicationContext, MovieListActivity::class.java)
                    startActivity(intent)
                }
                setPageTransformer(true, RotateDownTransformer())

                addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                    override fun onPageScrolled(
                        position: Int,
                        positionOffset: Float,
                        positionOffsetPixels: Int
                    ) {
                    }

                    override fun onPageSelected(position: Int) {
                    }

                    override fun onPageScrollStateChanged(state: Int) {
                    }

                })
            }

        }

    }

    private fun generateData() {
        menuItems.add(MenuItemModel("In Theater"))
        menuItems.add(MenuItemModel("Box Office"))

        homeItems.add(HomeItemModel("Ford v Ferrari", R.drawable.movie1, "8.1"))
        homeItems.add(HomeItemModel("Joker", R.drawable.movie2, "8.4"))
        homeItems.add(HomeItemModel("OLD", R.drawable.movie3, "5.8"))
    }
}


