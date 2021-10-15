package com.android.figmahomework

import android.content.Context
import androidx.annotation.NonNull

import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager.widget.PagerAdapter


class MovieViewPagerAdapter(private val context: Context, private val items: ArrayList<HomeItemModel>) : PagerAdapter() {
    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.item_movie_viewpager, collection, false) as ViewGroup
        val currentMoive = items[position]

        layout.findViewById<ImageView>(R.id.ivMovieImage).background = ResourcesCompat.getDrawable(context.resources, currentMoive.movieImageResId, null)
        layout.findViewById<TextView>(R.id.tvMoiveName).text = currentMoive.movieName
        layout.findViewById<TextView>(R.id.tvMovieRate).text = currentMoive.movieImdb

        collection.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }
}