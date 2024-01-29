package com.sport.results.app.presentation.sports.composables

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.sport.results.app.domain.model.SportModel
import org.junit.Rule
import org.junit.Test

class SportEntryTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun sportResultDisplayedCorrectly() {
        // Given a SportModel for testing
        val sportModel = SportModel(
            looser = "Schwartzman",
            numberOfSets = 3,
            publicationDate = "May 9, 2020 11:15:15 PM",
            tournament = "Roland Garros",
            winner = "Rafael Nadal",
            gameName = "Tennis"
        )

        // When the SportEntry composable is displayed
        composeTestRule.setContent {
            SportEntry(sport = sportModel)
        }

        // Then check if the relevant information is displayed correctly
        verifyTextDisplayed("Roland Garros", "Winner:", "Rafael Nadal", "Loser:", "Schwartzman", "Number of Sets:", "3", "11:15 PM")
    }

    @Test
    fun nbaResultDisplayedCorrectly() {
        // Given a SportModel for testing
        val sportModel = SportModel(6, "Heat", "Lebron James", "May 9, 2020 9:15:15 AM", "NBA playoffs", "Lakers")

        // When the SportEntry composable is displayed
        composeTestRule.setContent {
            SportEntry(sport = sportModel)
        }

        // Then check if the relevant information is displayed correctly
        verifyTextDisplayed("NBA playoffs", "Winner:", "Lakers", "Loser:", "Heat", "MVP:", "Lebron James", "Game Number:", "6", "09:15 AM")
    }

    @Test
    fun f1ResultDisplayedCorrectly() {
        // Given a SportModel for testing
        val sportModel = SportModel(
            publicationDate = "May 9, 2020 8:09:03 PM",
            seconds = 5.856,
            tournament = "Silverstone Grand Prix",
            winner = "Lewis Hamilton"
        )

        // When the SportEntry composable is displayed
        composeTestRule.setContent {
            SportEntry(sport = sportModel)
        }

        // Then check if the relevant information is displayed correctly
        verifyTextDisplayed("Silverstone Grand Prix", "Winner:", "Lewis Hamilton", "Seconds:", "5.856", "08:09 PM")
    }

    private fun verifyTextDisplayed(vararg texts: String) {
        texts.forEach { text ->
            composeTestRule
                .onNodeWithText(text)
                .assertExists()
        }
    }
}