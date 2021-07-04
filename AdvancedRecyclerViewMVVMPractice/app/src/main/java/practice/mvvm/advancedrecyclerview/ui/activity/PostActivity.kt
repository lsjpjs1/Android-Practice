package practice.mvvm.advancedrecyclerview.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_board.*
import practice.mvvm.advancedrecyclerview.R
import practice.mvvm.advancedrecyclerview.data.PostData
import practice.mvvm.advancedrecyclerview.databinding.ActivityPostBinding
import practice.mvvm.advancedrecyclerview.ui.adapter.PreviewAdapter
import practice.mvvm.advancedrecyclerview.ui.viewModel.PostViewModel

class PostActivity : AppCompatActivity() {
    private var viewModel: PostViewModel = PostViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = getIntent()
        val post = intent.getParcelableExtra<PostData>("post")
        viewModel.setPost(post!!)
        val binding = DataBindingUtil.setContentView<ActivityPostBinding>(this, R.layout.activity_post)
        binding.postVM = viewModel
        binding.setLifecycleOwner(this)

    }
}