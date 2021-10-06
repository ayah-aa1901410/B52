package com.cmps312.myapplication.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cmps312.myapplication.repository.SortByOptions

@Composable
fun SortDD(selectedOption: String, onSelectedOptionChange: (String) -> Unit) {
    var sortByOptions = listOf(
        SortByOptions.NONE,
        SortByOptions.CITY_NAME,
        SortByOptions.SEATING_CAPACITY,
        SortByOptions.STADIUM_NAME)

    var expanded by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.primary)) {
        Row(modifier = Modifier
            .height(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = selectedOption, color = MaterialTheme.colors.secondary)
            Icon(

                imageVector = Icons.Default.ArrowDropDown,
                tint = Color.White,
                contentDescription = "Sort By",
                modifier = Modifier.clickable { expanded = !expanded }
                    .padding(10.dp)
            )
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            sortByOptions.forEach { option ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    onSelectedOptionChange(option)

                }) {
                    Text(option)
                }
            }
        }
    }
}