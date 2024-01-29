package com.sport.results.app.presentation.sports.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sport.results.app.domain.model.SportModel

@Composable
fun DateSection(title : String , sports : List<SportModel>) {
    Box(modifier = Modifier.padding(10.dp).fillMaxWidth().background(color = Color.White).padding(10.dp)) {
        Column {
            Text(text = "Results for $title" , style = TextStyle(fontWeight = FontWeight.Bold))
            sports.forEach { sport ->
                SportEntry(sport = sport)
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun DateSectionPreview() {
    val sportOne = SportModel(
        gameNumber = 2,
        looser = "Heat",
        mvp = "Anthony Davis",
        publicationDate = "May 2, 2020 6:07:03 AM",
        tournament = "NBA playoffs",
        winner = "Lakers"
    )

    val sportTwo = SportModel(
        looser = "Schwartzman",
        numberOfSets = 3,
        publicationDate = "May 9, 2020 11:15:15 PM",
        tournament = "Roland Garros",
        winner = "Rafael Nadal"
    )

    val sportThree = SportModel(
        tournament = "Spa BELGIAN GRAND PRIX",
        seconds = 5.856,
        winner = "Lewis Hamilton",
        publicationDate = "Mar 15, 2020 8:09:03 PM",
    )

    val list = listOf( sportOne , sportTwo , sportThree)

    DateSection(
        title = "00-00-00",
        sports = list
    )
}