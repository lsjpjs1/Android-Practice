package practice.mvvm.advancedrecyclerview.ui.adapter

import android.view.View

interface RecyclerViewClickListener {
    fun onLikeButtonClick(view: View, position: Int)
    fun onPreviewClick(view: View, position: Int)
}