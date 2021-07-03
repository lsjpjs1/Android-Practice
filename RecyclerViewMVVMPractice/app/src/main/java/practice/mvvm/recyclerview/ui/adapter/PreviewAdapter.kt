package practice.mvvm.recyclerview.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import practice.mvvm.recyclerview.R
import practice.mvvm.recyclerview.databinding.PostPreviewBinding

class PreviewAdapter (val previewList: Array<String>) : RecyclerView.Adapter<PreviewAdapter.CustomViewHolder>(){

    inner class CustomViewHolder(val postPreviewBinding: PostPreviewBinding) : RecyclerView.ViewHolder(postPreviewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviewAdapter.CustomViewHolder =
        CustomViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.post_preview,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return previewList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.postPreviewBinding.preview=previewList[position]
    }



}