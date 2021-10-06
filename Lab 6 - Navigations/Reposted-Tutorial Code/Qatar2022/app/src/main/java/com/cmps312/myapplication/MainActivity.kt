package com.cmps312.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.cmps312.myapplication.repository.StadiumRepo
import com.cmps312.myapplication.ui.theme.MyApplicationTheme
import com.cmps312.myapplication.views.SearchBar
import com.cmps312.myapplication.views.SortDD
import com.cmps312.myapplication.views.StadiumList
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp(this)
                }
            }
        }
    }
}

@Composable
fun MyApp(context: Context) {
    val stadiums = StadiumRepo.getStadiums(context)
    var searchText by remember {
        mutableStateOf("")
    }
    var selectedOption by remember {
        mutableStateOf("Sort By")
    }

    Scaffold(
        topBar = {
            Column(modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .fillMaxWidth()) {
                SearchBar(searchText, onSearch = { searchText = it })
                SortDD(selectedOption, onSelectedOptionChange = {
                    selectedOption = it
                })
            }
        },
        content = {
            val filteredStadiums = stadiums.filter {
                it.name
                    .lowercase(Locale.getDefault())
                    .contains(searchText.lowercase(Locale.getDefault()))
            }
            val filteredAndSorted = StadiumRepo.sortStadiums(selectedOption, filteredStadiums)
            StadiumList(filteredAndSorted)
        },
        drawerContent = { StadiumList(stadiums) }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MyApp(LocalContext.current)
    }
}