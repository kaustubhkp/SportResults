package com.sport.results.app.domain.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class ResultResponseTest {

    @Test
    fun testGetMap() {
        val fOneResults = getF1Results()
        val nbaResults = getNBAResults()
        val tennisResults = getTennisResults()

        val resultResponse = ResultResponse(fOneResults, nbaResults, tennisResults)

        val resultMap = resultResponse.getMap()

        assertEquals(1, resultMap.size)
        assertEquals("2020-05-09", resultMap.keys.first())
        assertEquals(4, resultMap.values.first().size)
    }

    private fun getF1Results() = arrayListOf(
        SportModel(
            publicationDate = "May 9, 2020 8:09:03 PM",
            seconds = 5.856,
            tournament = "Silverstone Grand Prix",
            winner = "Lewis Hamilton"
        ),
        SportModel(
            publicationDate = "Apr 14, 2020 8:09:03 PM",
            seconds = 7.729,
            tournament = "VTB RUSSIAN GRAND PRIX",
            winner = "Valtteri Bottas"
        ),
        SportModel(
            publicationDate = "Mar 15, 2020 8:09:03 PM",
            seconds = 5.856,
            tournament = "Spa BELGIAN GRAND PRIX",
            winner = "Lewis Hamilton"
        )
    )

    private fun getNBAResults() = arrayListOf(
        SportModel(6, "Heat", "Lebron James", "May 9, 2020 9:15:15 AM", "NBA playoffs", "Lakers"),
        SportModel(5, "Lakers", "Jimmy Butler", "May 7, 2020 3:15:00 PM", "NBA playoffs", "Heat"),
        SportModel(4, "Heat", "Anthony Davis", "May 5, 2020 1:34:15 PM", "NBA playoffs", "Lakers"),
        SportModel(3, "Lakers", "Jimmy Butler", "May 3, 2020 9:15:33 PM", "NBA playoffs", "Heat"),
        SportModel(2, "Heat", "Anthony Davis", "May 2, 2020 6:07:03 AM", "NBA playoffs", "Lakers")
    )

    private fun getTennisResults() = arrayListOf(
        SportModel(
            looser = "Schwartzman ",
            numberOfSets = 3,
            publicationDate = "May 9, 2020 11:15:15 PM",
            tournament = "Roland Garros",
            winner = "Rafael Nadal"
        ),
        SportModel(
            looser = "Stefanos Tsitsipas ",
            numberOfSets = 3,
            publicationDate = "May 9, 2020 2:00:40 PM",
            tournament = "Roland Garros",
            winner = "Novak Djokovic"
        ),
        SportModel(
            looser = "Petra Kvitova",
            numberOfSets = 3,
            publicationDate = "May 8, 2020 4:33:17 PM",
            tournament = "Roland Garros",
            winner = "Sofia Kenin"
        )
    )
}