package com.example.jetpackcomposenavigation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Hello $name", fontSize = 30.sp)
    }
}