package com.example.jetpackcomposelazycolumn.presentation

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcomposelazycolumn.data.TvShowList
import com.example.jetpackcomposelazycolumn.domain.models.TvShow
import com.example.jetpackcomposelazycolumn.presentation.utils.Screen
import com.google.gson.Gson

//@Composable
//    fun TvShowListScreen(selectedItem: (TvShow) -> Unit) {
//val tvShows: List<TvShow> = TvShowList.tvShows
//    LazyColumn(
//        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
//    ) {
//        items(
//            items = tvShows,
//            itemContent = {
//                TvShowListItem(tvShow = it, selectedItem)
//            }
//        )
//    }
//}


@Composable
fun TvShowListScreen(navController: NavController) {
    val tvShows: List<TvShow> = TvShowList.tvShows
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
    ) {
        items(
            items = tvShows
        ) {
            TvShowListItem(tvShow = it, { selectedShow->

                //navigation by Passing the object using NavBackStackEntry
//                navController.currentBackStackEntry?.savedStateHandle?.set("tvShow", selectedShow)
//                navController.navigate(Screen.TvShowDetailScreen.route)


                //navigation by Converting the TvShow object into JSON string
                val tvShowJsonString = Gson().toJson(selectedShow)
                navController.navigate(
                    Screen.TvShowDetailScreen.route + "?tvShow=${tvShowJsonString}"
                )
            })
        }
    }
}
