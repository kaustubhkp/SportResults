package com.sport.results.app.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.sport.results.app.utils.Utils
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultResponse(
    @SerializedName("f1Results") var fOne: ArrayList<SportModel> = arrayListOf(),
    @SerializedName("nbaResults") var nba: ArrayList<SportModel> = arrayListOf(),
    @SerializedName("Tennis") var tennis: ArrayList<SportModel> = arrayListOf()
) : Parcelable {

    fun getMap(): Map<String, List<SportModel>> {
        val map = mutableMapOf<String, MutableList<SportModel>>()

        fun processGames(games: List<SportModel>, gameName: String) {
            games.forEach { game ->
                game.publicationDate?.let { dateTimeString ->
                    val date = Utils.getDateObjectFromString(dateTimeString)
                    val dateString = Utils.getStringDate(date)
                    game.gameName = gameName
                    map.getOrPut(dateString) { mutableListOf() }.add(game)
                }
            }
        }

        processGames(fOne, "F1")
        processGames(nba, "NBA")
        processGames(tennis, "Tennis")

        val firstEntry = map.toMutableMap().entries.first()

        return mapOf(firstEntry.key to firstEntry.value)
    }
}