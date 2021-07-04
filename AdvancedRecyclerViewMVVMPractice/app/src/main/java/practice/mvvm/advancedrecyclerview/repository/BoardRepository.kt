package practice.mvvm.advancedrecyclerview.repository

import practice.mvvm.advancedrecyclerview.data.PostData

class BoardRepository {
    private val previewList: ArrayList<PostData> = arrayListOf(PostData("hoon","post body",1,2))
    private lateinit var newPreview: PostData
    fun getPreviewList(): ArrayList<PostData> {
        return previewList
    }

    fun getNewPreview(size: Int): PostData{
        return PostData("hoon$size","post body",0,0)
    }

}