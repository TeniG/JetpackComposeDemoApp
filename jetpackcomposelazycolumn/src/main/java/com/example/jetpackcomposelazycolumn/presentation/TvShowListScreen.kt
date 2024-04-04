package com.example.jetpackcomposelazycolumn.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposelazycolumn.data.TvShowList
import com.example.jetpackcomposelazycolumn.domain.models.TvShow
import com.example.jetpackcomposelazycolumn.presentation.utils.Screen

@Composable
    fun TvShowListScreen(selectedItem: (TvShow) -> Unit) {
val tvShows: List<TvShow> = TvShowList.tvShows
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
    ) {
        items(
            items = tvShows,
            itemContent = {
                TvShowListItem(tvShow = it, selectedItem)
            }
        )
    }
}

