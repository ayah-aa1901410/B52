package com.cmps312.stadiumapp.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.cmps312.stadiumapp.model.Stadium

@Composable
fun StadiumList(stadiums: List<Stadium>) {
    if (stadiums.isEmpty()) {
        Text(text = "No Stadiums to Display")
    } else {
        LazyColumn { items(stadiums) { StadiumCard(stadium = it)}}
    }
}