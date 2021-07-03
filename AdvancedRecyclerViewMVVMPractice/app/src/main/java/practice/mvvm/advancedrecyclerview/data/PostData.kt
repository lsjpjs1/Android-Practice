package practice.mvvm.advancedrecyclerview.data

data class PostData(
    var user_nickname: String,
    var post_body: String,
    var like_count: Int,
    var comment_count: Int
)