package practice.mvvm.advancedrecyclerview.repository

class BoardRepository {
    private val previewList: Array<String> = arrayOf("a","b","c","d")
    private val changedPreviewList: Array<String> = arrayOf("1","2","3","4")
    fun getPreviewList(): Array<String> {
        return previewList
    }
    fun getChangedPreviewList(): Array<String> {
        return changedPreviewList
    }
}