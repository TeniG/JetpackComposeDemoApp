package com.example.jetpackcomposenavigation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {

    var text by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            placeholder = {
                Text("Enter your Name")
            },
            textStyle = TextStyle(fontSize = 20.sp),
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                navController.navigate("detail_screen/$text")
            },
        ) {
            Text(" Go to DetailScreen")
        }
    }
}