package com.android.figmahomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.figmahomework.FadingImageView.FadeSide
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFadingImageView = findViewById<View>(R.id.ivBackground) as FadingImageView


        mFadingImageView.setEdgeLength(100)
        mFadingImageView.setFadeDirection(FadeSide.UP_SIDE)
        mFadingImageView.setEdgeLength(200)
        mFadingImageView.setFadeDirection(FadeSide.DOWN_SIDE)


    }
}