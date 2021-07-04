package practice.mvvm.advancedrecyclerview.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import practice.mvvm.advancedrecyclerview.data.PostData

class PostViewModel : ViewModel(){
    private val _post = MutableLiveData<PostData>()

    val post : LiveData<PostData>
        get() = _post

    fun setPost(data: PostData){
        _post.value = data
    }
}