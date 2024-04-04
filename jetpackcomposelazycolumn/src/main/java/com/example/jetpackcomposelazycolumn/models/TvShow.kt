package com.example.jetpackcomposelazycolumn.domain.models

import java.io.Serializable


data class TvShow(
    val id: Int,
    val name: String,
    val year: Int,
    val rating : Double,
    val imageId : Int,
    val overview : String
) : Serializable
