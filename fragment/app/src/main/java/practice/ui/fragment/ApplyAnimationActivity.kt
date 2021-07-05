package practice.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class ApplyAnimationActivity : AppCompatActivity() {
    val duration = (200).toLong()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment1,FragmentOne()).commit()
        supportFragmentManager.beginTransaction().add(R.id.fragment2,FragmentTwo()).commit()
        supportFragmentManager.beginTransaction().add(R.id.fragment3,FragmentThree()).commit()
        button3.setOnClickListener {
            showFragment(linear2)
        }
        button4.setOnClickListener {
            hideFragment(linear2)
        }
    }
    fun showFragment(view: View){

        expandAnimation(view)
    }
    fun hideFragment(view: View){
        collapseAnimation(view)
    }

    fun expandAnimation(view: View){
        if(view.visibility == View.GONE) {
            val layoutparams = view.layoutParams as LinearLayout.LayoutParams
            val weight = layoutparams.weight
            layoutparams.weight = 0f
            view.visibility = View.VISIBLE
            val animation = object : Animation() {
                override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                    layoutparams.weight =
                        if (interpolatedTime == 1f) 1f
                        else weight * interpolatedTime
                    view.requestLayout()
                    Log.i("weight", layoutparams.weight.toString())
                }
            }

            animation.duration = duration
            view.startAnimation(animation)
        }
    }

    fun collapseAnimation(view: View) {
        if (view.visibility == View.VISIBLE) {
            val layoutparams = view.layoutParams as LinearLayout.LayoutParams
            val weight = layoutparams.weight

            val animation = object : Animation() {
                override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                    if (interpolatedTime == 1f) {
                        view.visibility = View.GONE
                        layoutparams.weight = weight
                    } else {
                        layoutparams.weight = weight - (weight * interpolatedTime)
                        view.requestLayout()
                    }
                }
            }

            animation.duration = duration
            view.startAnimation(animation)
        }
    }
}