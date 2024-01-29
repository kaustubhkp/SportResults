package com.sport.results.app.presentation.sports.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sport.results.app.domain.model.SportModel
import com.sport.results.app.ui.theme.GreenDark
import com.sport.results.app.ui.theme.GreyLight
import com.sport.results.app.ui.theme.PurpleGrey40
import com.sport.results.app.ui.theme.RedDark
import com.sport.results.app.ui.theme.YellowDark
import com.sport.results.app.utils.Utils

@Composable
fun SportEntry(sport: SportModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(color = GreyLight, shape = RoundedCornerShape(size = 10.dp))
            .padding(10.dp)

    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                sport.tournament?.let { tournament ->
                    Text(text = tournament, style = TextStyle(fontWeight = FontWeight.Black))
                }
                Spacer(modifier = Modifier.width(5.dp))
                sport.gameName?.let { gameName ->
                    Text(text = "$gameName", style = TextStyle(fontWeight = FontWeight.Black , color = PurpleGrey40))
                }
            }



            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                sport.winner?.let {
                    Row(
                        modifier = Modifier.weight(1.0f),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Winner:" , style = TextStyle(color = Black, ))
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = it,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(color = GreenDark, fontWeight = FontWeight.Black)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(5.dp))
                sport.looser?.let {
                    Row(
                        modifier = Modifier.weight(1.0f),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Loser:" , style = TextStyle(color = Black, ))
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = it,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(color = RedDark, fontWeight = FontWeight.Black)
                        )
                    }
                }
            }

            sport.mvp?.let {
                Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically){
                    Text(text = "MVP:" , style = TextStyle(color = Black, ))
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "$it",
                        style = TextStyle(color = YellowDark, fontWeight = FontWeight.Black)
                    )
                }
            }

            sport.seconds?.let { it ->
                Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Seconds:" , style = TextStyle(color = Black, ))
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "$it",
                        style = TextStyle(color = Black, fontWeight = FontWeight.Black)
                    )
                }
            }
            sport.numberOfSets?.let {
                Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Number of Sets:" , style = TextStyle(color = Black, ))
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "$it",
                        style = TextStyle(color = Black, fontWeight = FontWeight.Black)
                    )
                }
            }
            sport.gameNumber?.let {
                Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically){
                    Text(text = "Game Number:" , style = TextStyle(color = Black, ))
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "$it",
                        style = TextStyle(color = Black, fontWeight = FontWeight.Black)
                    )
                }
            }

            sport.publicationDate?.let { date ->
                Spacer(modifier = Modifier.height(7.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Text(
                        text = Utils.getStringTime(date),
                        style = TextStyle(color = PurpleGrey40, fontWeight = FontWeight.Black)
                    )
                }
            }


        }

    }
}


@Preview(showBackground = true)
@Composable
fun SportEntryPreview() {
    SportEntry(
        sport = SportModel(
            looser = "Schwartzman",
            numberOfSets = 3,
            publicationDate = "May 9, 2020 11:15:15 PM",
            tournament = "Roland Garros",
            winner = "Rafael Nadal",
            gameName = "Tennis"
        )
    )
}