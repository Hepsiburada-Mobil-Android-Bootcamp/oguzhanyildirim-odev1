package com.android.figmahomework

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.ImageView


open class FadingImageView : androidx.appcompat.widget.AppCompatImageView {
    private var mFadeSide: FadeSide? = null
    private var c: Context

    enum class FadeSide {
        UP_SIDE, DOWN_SIDE
    }

    constructor(c: Context, attrs: AttributeSet?, defStyle: Int) : super(c, attrs, defStyle) {
        this.c = c
        init()
    }

    constructor(c: Context, attrs: AttributeSet?) : super(c, attrs) {
        this.c = c
        init()
    }

    constructor(c: Context) : super(c) {
        this.c = c
        init()
    }

    private fun init() {
        // Enable horizontal fading
        this.isVerticalFadingEdgeEnabled = true
        this.scaleType = ScaleType.CENTER_CROP
    }

    fun setFadeDirection(side: FadeSide?) {
        mFadeSide = side
    }

    fun setEdgeLength(length: Int) {
        this.setFadingEdgeLength(getPixels(length))
    }

    override fun getBottomFadingEdgeStrength(): Float {
        return if (mFadeSide == FadeSide.DOWN_SIDE) 0.4f else 0.1f
    }

    override fun getTopFadingEdgeStrength(): Float {
        return if (mFadeSide == FadeSide.UP_SIDE) 1.0f else 0.0f
    }

    override fun hasOverlappingRendering(): Boolean {
        return true
    }

    override fun onSetAlpha(alpha: Int): Boolean {
        return false
    }

    private fun getPixels(dipValue: Int): Int {
        val r: Resources = c.resources
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dipValue.toFloat(), r.displayMetrics
        ).toInt()
    }
}