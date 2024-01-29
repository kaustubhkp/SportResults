package com.sport.results.app.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sport.results.app.utils.Utils
import kotlinx.parcelize.Parcelize

@Parcelize
class SportModel(
    @SerializedName("gameNumber") var gameNumber: Int? = null,
    @SerializedName("looser") var looser: String? = null,
    @SerializedName("mvp") var mvp: String? = null,
    @SerializedName("publicationDate") var publicationDate: String? = null,
    @SerializedName("tournament") var tournament: String? = null,
    @SerializedName("winner") var winner: String? = null,
    @SerializedName("seconds") var seconds: Double? = null,
    @SerializedName("numberOfSets") var numberOfSets: Int? = null,
    @SerializedName("gameName") var gameName: String? = null
) : Parcelable, Comparable<SportModel> {
    override fun compareTo(other: SportModel): Int =
        Utils.getDateObjectFromString(other.publicationDate!!)
            .compareTo(Utils.getDateObjectFromString(publicationDate!!)) * -1
}