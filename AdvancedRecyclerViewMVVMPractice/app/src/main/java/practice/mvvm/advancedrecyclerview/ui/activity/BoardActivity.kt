package practice.mvvm.advancedrecyclerview.ui.activity

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_board.*
import practice.mvvm.advancedrecyclerview.R
import practice.mvvm.advancedrecyclerview.databinding.ActivityBoardBinding
import practice.mvvm.advancedrecyclerview.ui.adapter.PreviewAdapter
import practice.mvvm.advancedrecyclerview.ui.viewModel.BoardViewModel


class BoardActivity : AppCompatActivity(){
    private var viewModel: BoardViewModel = BoardViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityBoardBinding>(this, R.layout.activity_board)
        binding.boardVM= viewModel
        binding.setLifecycleOwner(this)
        viewModel.getPreviews()

        viewModel.previews.observe(this, Observer { previews ->
            rv_post_preview.also {
                it.layoutManager = LinearLayoutManager(this)
                it.setHasFixedSize(true)
                it.adapter = PreviewAdapter(previews)
            }
        })


    }
}