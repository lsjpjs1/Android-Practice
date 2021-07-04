package practice.mvvm.advancedrecyclerview.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import practice.mvvm.advancedrecyclerview.data.PostData
import practice.mvvm.advancedrecyclerview.repository.BoardRepository


class BoardViewModel : ViewModel(){
    private val _posts = MutableLiveData<ArrayList<PostData>>()
    private val repository: BoardRepository = BoardRepository()

    val posts : LiveData<ArrayList<PostData>>
        get() = _posts

    fun getPreviews() {
        _posts.value = repository.getPreviewList()
    }
    fun addNewPreivew() {
        val newPreview = repository.getNewPreview(_posts.value!!.size+1)
        val oldPreview = _posts.value!!
        oldPreview.add(newPreview)
        _posts.value = oldPreview
    }
    fun addLike(position: Int) {
        val oldPreview = _posts.value!!
        oldPreview[position].like_count+=1
        _posts.value = oldPreview
        Log.i("post_value",_posts.value.toString())
    }

    fun getSelectedPreview(position: Int): PostData {
        return _posts.value!![position]
    }



}