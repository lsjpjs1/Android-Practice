package practice.ui.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
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
        view.visibility = View.VISIBLE
    }
    fun hideFragment(view: View){
        view.visibility = View.GONE
    }
}