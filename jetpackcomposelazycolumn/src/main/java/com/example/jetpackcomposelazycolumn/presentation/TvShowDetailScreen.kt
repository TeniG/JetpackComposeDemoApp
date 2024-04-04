package com.example.jetpackcomposelazycolumn.presentation

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackcomposelazycolumn.domain.models.TvShow

//StackOverflow: https://stackoverflow.com/questions/67121433/how-to-pass-object-in-navigation-in-jetpack-compose
@Composable
fun TvShowDetail(navController: NavController) {

    val selectedTvShow: TvShow? = navController.previousBackStackEntry?.savedStateHandle?.get("tvShow")  as? TvShow

    Log.d("TvShowDetailScreen", "selectedTvShow: ${selectedTvShow}")

    val scrollState = rememberScrollState()
    val tvShow by remember {
        mutableStateOf(selectedTvShow)
    }
    tvShow?.let {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            shape = RoundedCornerShape(corner = CornerSize(10.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .verticalScroll(scrollState)
            ) {

                Image(
                    painter = painterResource(id = tvShow!!.imageId),
                    contentDescription = tvShow!!.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(4.dp)),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = tvShow!!.name,
                    style = MaterialTheme.typography.headlineLarge,
                    fontSize = 42.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ratings : ${tvShow!!.rating}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Original release : ${tvShow!!.year}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = tvShow!!.overview,
                    style = MaterialTheme.typography.bodyLarge,
                    fontStyle = FontStyle.Italic,
                    fontSize = 16.sp
                )

            }
        }
    }

}