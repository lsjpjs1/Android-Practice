package practice.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class ApplyAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment1,FragmentOne()).commit()
        supportFragmentManager.beginTransaction().add(R.id.fragment2,FragmentTwo()).commit()
        supportFragmentManager.beginTransaction().add(R.id.fragment3,FragmentThree()).commit()
        button3.setOnClickListener {
            showFragment(fragment2)
        }
        button4.setOnClickListener {
            hideFragment(fragment2)
        }
    }
    fun showFragment(view: View){

        expandAnimation(view)
    }
    fun hideFragment(view: View){
        collapseAnimation(view)
    }

    fun expandAnimation(view: View){
        view.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val height = view.measuredHeight
        view.layoutParams.height = 0
        view.visibility = View.VISIBLE
        val animation = object : Animation(){
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                val duration = 50f
                view.layoutParams.height =
                    if (interpolatedTime == duration) ViewGroup.LayoutParams.WRAP_CONTENT
                    else (height * interpolatedTime).toInt()
                view.requestLayout()
            }
        }

        animation.duration = (height / view.context.resources.displayMetrics.density*5).toLong()
        view.startAnimation(animation)
    }

    fun collapseAnimation(view: View) {
        view.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val height = view.measuredHeight

        val animation = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                val duration = 1f
                if (interpolatedTime == duration) {
                    view.visibility = View.GONE
                } else {
                    view.layoutParams.height = (height - (height * interpolatedTime)).toInt()
                    view.requestLayout()
                }
            }
        }

        animation.duration = (height / view.context.resources.displayMetrics.density).toLong()
        view.startAnimation(animation)
    }
}