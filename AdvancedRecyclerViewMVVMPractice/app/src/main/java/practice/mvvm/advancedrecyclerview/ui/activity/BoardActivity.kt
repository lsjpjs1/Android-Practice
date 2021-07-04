package practice.mvvm.advancedrecyclerview.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_board.*
import practice.mvvm.advancedrecyclerview.R
import practice.mvvm.advancedrecyclerview.data.PostData
import practice.mvvm.advancedrecyclerview.databinding.ActivityBoardBinding
import practice.mvvm.advancedrecyclerview.ui.adapter.PreviewAdapter
import practice.mvvm.advancedrecyclerview.ui.adapter.RecyclerViewClickListener
import practice.mvvm.advancedrecyclerview.ui.viewModel.BoardViewModel


class BoardActivity : AppCompatActivity(),RecyclerViewClickListener{
    private var viewModel: BoardViewModel = BoardViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityBoardBinding>(this, R.layout.activity_board)
        binding.boardVM= viewModel
        binding.setLifecycleOwner(this)
        viewModel.getPreviews()

        viewModel.posts.observe(this, Observer { posts ->
            rv_post_preview.also {
                it.layoutManager = GridLayoutManager(this,1)
                it.setHasFixedSize(true)
                it.adapter = PreviewAdapter(posts,this)
            }
        })


    }

    override fun onLikeButtonClick(view: View, position: Int) {
        viewModel.addLike(position)
    }

    override fun onPreviewClick(view: View, position: Int) {
        val selectedPreview = viewModel.getSelectedPreview(position)
        goPost(selectedPreview)
    }

    fun goPost(post: PostData){
        val intent = Intent(this, PostActivity::class.java)
        intent.putExtra("post",post)
        startActivity(intent)
    }


}

