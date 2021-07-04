package practice.mvvm.advancedrecyclerview.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import practice.mvvm.advancedrecyclerview.R
import practice.mvvm.advancedrecyclerview.data.PostData
import practice.mvvm.advancedrecyclerview.databinding.PostPreviewBinding


class PreviewAdapter (val postList: ArrayList<PostData>, private val listener: RecyclerViewClickListener) : RecyclerView.Adapter<PreviewAdapter.CustomViewHolder>(){

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
        return postList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.postPreviewBinding.post=postList[position]
        holder.postPreviewBinding.likeButton.setOnClickListener{
            listener.onLikeButtonClick(holder.postPreviewBinding.likeButton,position)
        }
        holder.postPreviewBinding.clPreview.setOnClickListener{
            listener.onPreviewClick(holder.postPreviewBinding.clPreview,position)
        }
    }



}