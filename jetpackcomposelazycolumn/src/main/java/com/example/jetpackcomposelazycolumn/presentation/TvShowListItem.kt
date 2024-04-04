package com.example.jetpackcomposelazycolumn.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposelazycolumn.domain.models.TvShow

@Composable
fun TvShowListItem(tvShow: TvShow, selectedItem: (TvShow) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))

    ) {
        Row(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth()
                .clickable { selectedItem(tvShow) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            TvShowImage(tvShow)
            Spacer(modifier = Modifier.width(4.dp))
            Column {
                Text(
                    text = tvShow.name,
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = tvShow.overview,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = tvShow.year.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = tvShow.rating.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun TvShowImage(tvShow: TvShow) {
    Image(
        painter = painterResource(id = tvShow.imageId),
        contentDescription = tvShow.name,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(5.dp)
            .height(140.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(10.dp))
    )
}