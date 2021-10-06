package com.cmps312.navigationsbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cmps312.navigationsbasics.ui.theme.NavigationsBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationsBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

//Todo 1
@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) {
        MyNavHost(navController)
    }
}

//Todo 2
@Composable
fun BottomNavBar(navController: NavHostController) {
    var selected by remember {
        mutableStateOf(1)
    }
    BottomAppBar(
        content = {
            BottomNavigationItem(
                selected = selected == 1,
                onClick = {
                    selected = 1
                    navController.navigate("homescreen")
                },
                label = { Text(text = "Home") },
                icon = {
                    Icon(imageVector = Icons.Default.Home,
                        contentDescription = "Favourites")
                },
                alwaysShowLabel = true)
            Text(text = "|")
            BottomNavigationItem(
                selected = selected == 2,
                onClick = {
                    selected = 2
                    navController.navigate("detailsscreen")
                },
                label = { Text(text = "Favourites") },
                icon = {
                    Icon(imageVector = Icons.Default.Favorite,
                        contentDescription = "Favourites")
                },
                alwaysShowLabel = true)
        }
    )
}

//Todo 3
@Composable
fun MyNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "homescreen") {
        //Mapping /HomeScreen --- take them to this screen
        //Possible Routes in my app
        composable("homescreen") { HomeScreen(navController) }
        composable("detailsscreen") { DetailsScreen(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        Text(text = "Home Screen")
        Button(onClick = { navController.navigate("detailsScreen") }) {
            Text("Go to Detail Screen")
        }
    }
}

@Composable
fun DetailsScreen(navController: NavHostController) {
    Column {
        Text(text = "Detail Screen")
        Button(onClick = { navController.navigate("homescreen") }) {
            Text("Go to Home Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationsBasicsTheme {
        MyApp()
    }
}