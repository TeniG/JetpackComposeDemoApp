package com.example.jetpackcomposecounterapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

     var count by mutableIntStateOf(0)

    fun incrementCounter() {
        count++
    }
}