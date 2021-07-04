package practice.mvvm.advancedrecyclerview.data

import android.os.Parcel
import android.os.Parcelable

data class PostData(
    var user_nickname: String?,
    var post_body: String?,
    var like_count: Int,
    var comment_count: Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(user_nickname)
        parcel.writeString(post_body)
        parcel.writeInt(like_count)
        parcel.writeInt(comment_count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PostData> {
        override fun createFromParcel(parcel: Parcel): PostData {
            return PostData(parcel)
        }

        override fun newArray(size: Int): Array<PostData?> {
            return arrayOfNulls(size)
        }
    }
}