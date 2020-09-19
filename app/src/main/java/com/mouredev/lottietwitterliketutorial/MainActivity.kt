package com.mouredev.lottietwitterliketutorial

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var like = false

        likeImageView.setOnClickListener {
            like = likeAnimation(likeImageView, R.raw.bandai_dokkan, like)
        }

        var like2 = false

        like2ImageView.setOnClickListener {
            like2 = likeAnimation(like2ImageView, R.raw.apple_event, like2)
        }

        var like3 = false

        like3ImageView.setOnClickListener {
            like3 = likeAnimation(like3ImageView, R.raw.black_joy, like3)
        }

        var like4 = false

        like4ImageView.setOnClickListener {
            like4 = likeAnimation(like4ImageView, R.raw.always_proud, like4)
        }

        var like5 = false

        like5ImageView.setOnClickListener {
            like5 = likeAnimation(like5ImageView, R.raw.hmm, like5)
        }
    }

    private fun likeAnimation(imageView: LottieAnimationView,
                              animation: Int,
                              like: Boolean) : Boolean {

        if (!like) {
            imageView.setAnimation(animation)
            imageView.playAnimation()
        } else {
            imageView.animate()
                .alpha(0f)
                .setDuration(200)
                .setListener(object : AnimatorListenerAdapter() {

                    override fun onAnimationEnd(animator: Animator) {

                        imageView.setImageResource(R.drawable.twitter_like)
                        imageView.alpha = 1f
                    }

                })

        }

        return !like
    }

}