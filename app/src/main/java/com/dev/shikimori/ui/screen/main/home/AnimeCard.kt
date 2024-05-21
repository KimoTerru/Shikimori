package com.dev.shikimori.ui.screen.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dev.shikimori.R

@Composable
fun AnimeCard(
    modifier: Modifier = Modifier,
    animeId: String,
    animeName: String,
    animeImage: String,
    animeStatus: String,
    animeType: String,
    animeEpisodes: String,
    animeWatchedEpisode: Int,
    animeScore: Float
) {
    ElevatedCard(
        modifier = modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .height(160.dp),
        onClick = {
            // TODO: Navigate to anime details screen
        }
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = modifier
                    .width(100.dp),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = animeName,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold
                )
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = animeStatus
                    )
                    Spacer(modifier = modifier.size(10.dp))
                    Text(
                        text = animeType
                    )
                    Spacer(modifier = modifier.size(10.dp))
                    Text(
                        text = animeEpisodes
                    )
                }
                Spacer(modifier = modifier.weight(1f))
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextWithIcon(text = animeScore.toString(), icon = R.drawable.star_outlined)
                    Text(text = "-")
                    TextWithIcon(
                        text = animeWatchedEpisode.toString(),
                        icon = R.drawable.visibility
                    )
                    Spacer(modifier = modifier.weight(1f))
                    FilledTonalButton(
                        onClick = {
                            // TODO: Navigate to changed anime screen
                        },
                        contentPadding = PaddingValues(horizontal = 12.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.pencil_outlined),
                            contentDescription = null
                        )
                        Spacer(modifier = modifier.size(8.dp))
                        Text(
                            text = stringResource(id = R.string.change),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TextWithIcon(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int
) {
    Row {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Text(
            text = text,
            fontWeight = FontWeight.Medium
        )
    }
}