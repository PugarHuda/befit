package com.example.recyclerviewkotlin

import android.os.Parcel
import android.os.Parcelable

data class DataClass(var dataImageProf:Int, var dataUserName:String, var dataTime: String, var dataComment: Int, var dataLikes: Int, var dataReplies: Int): Parcelable {
    constructor(parcel: Parcel) :  this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImageProf)
        parcel.writeString(dataUserName)
        parcel.writeString(dataTime)
        parcel.writeInt(dataComment)
        parcel.writeInt(dataLikes)
        parcel.writeInt(dataReplies)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataClass> {
        override fun createFromParcel(parcel: Parcel): DataClass {
            return DataClass(parcel)
        }

        override fun newArray(size: Int): Array<DataClass?> {
            return arrayOfNulls(size)
        }
    }
}