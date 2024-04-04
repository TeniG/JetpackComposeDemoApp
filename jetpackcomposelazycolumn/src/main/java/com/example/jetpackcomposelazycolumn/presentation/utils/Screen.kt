package com.example.jetpackcomposelazycolumn.presentation.utils

sealed class Screen(val route: String) {
    object TvShowListScreen : Screen(route = "tv_show_list_screen")
    object TvShowDetailScreen : Screen(route = "tv_show_detail_screen")
}