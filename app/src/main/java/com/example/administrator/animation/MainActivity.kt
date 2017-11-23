package com.example.administrator.animation

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(v: View) {
        val width = ValueAnimator.ofInt(button.width, 500)
        val widthParams = button.layoutParams
        width.addUpdateListener {
            widthParams.width = it.animatedValue as Int
            button.layoutParams = widthParams
        }

        val height = ValueAnimator.ofInt(button.height, 500)
        val heightParams = button.layoutParams
        height.addUpdateListener {
            widthParams.height = it.animatedValue as Int
            button.layoutParams = heightParams
        }

        val color=ValueAnimator.ofFloat(0f, 1f)
        color.addUpdateListener {
            val value=it.animatedValue as Float
            val color=ArgbEvaluator().evaluate(
                    value,Color.parseColor("#636978"),
                    Color.parseColor("#1AD372")) as Int
            button.setBackgroundColor(color)
        }

        val set=AnimatorSet()
        set.playTogether(width,height,color)
        set.duration=500
        set.interpolator = OvershootInterpolator()
        set.start()
    }
}
