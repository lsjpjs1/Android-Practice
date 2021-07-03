package practice.mvvm.advancedrecyclerview.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import practice.mvvm.advancedrecyclerview.repository.BoardRepository


class BoardViewModel : ViewModel(){
    private val _previews = MutableLiveData<Array<String>>()
    private val repository: BoardRepository = BoardRepository()

    val previews : LiveData<Array<String>>
        get() = _previews

    fun getPreviews() {
        _previews.value = repository.getPreviewList()
    }
    fun getChangedPreviews() {
        _previews.value = repository.getChangedPreviewList()
    }
}