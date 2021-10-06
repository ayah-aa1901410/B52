package com.cmps312.myapplication.repository

import android.content.Context
import com.cmps312.myapplication.model.Stadium
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.util.*

//Todo Add the SortBy
object SortByOptions {
    val NONE = "None"
    val STADIUM_NAME = "Stadium Name"
    val CITY_NAME = "City Name"
    val SEATING_CAPACITY = "Seating Capacity"

}

object StadiumRepo {
    private var stadiums = listOf<Stadium>()

    fun getStadiums(context: Context): List<Stadium> {
        if (stadiums.isEmpty()) {
            val stadiumJsonString = context
                .assets.open("stadiums.json")
                .bufferedReader().use { it.readText() }

            //convert the stadiums json to Stadiums object
            stadiums = Json.decodeFromString(stadiumJsonString)
        }
        return stadiums
    }

    fun filterStadiumByStatus(status: String) = when (status) {
        "All" -> stadiums
        else -> stadiums.filter { it.status.contains(status) }
    }

    fun filterStadiumByName(status: String) = stadiums.filter {
        it.name.lowercase(Locale.getDefault()).contains(status.lowercase(
            Locale.getDefault()))
    }

    fun getStadium(name: String) = stadiums.find { it.name.contains(name) }

    //todo implement the sort

    fun sortStadiums(sortOption: String, stadiums: List<Stadium>) = when (sortOption) {
        SortByOptions.STADIUM_NAME -> stadiums.sortedBy { it.name }
        SortByOptions.CITY_NAME -> stadiums.sortedBy { it.city }
        SortByOptions.SEATING_CAPACITY -> stadiums.sortedBy { it.seatingCapacity }
        else -> stadiums
    }

}