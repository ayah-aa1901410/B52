package com.cmps312.bankingapp.view

import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navHostController = rememberNavController()

    Scaffold(
        topBar = { TopBar(navHostController) },
        bottomBar = { BottomBar(navHostController) }
    ) {
        AppNavHost(navHostController)
    }
}

@Composable
fun BottomBar(navHostController: NavHostController) {
    val bottomNavItems = listOf(
        Screen.TransferList,
        Screen.FundTransfer,
        Screen.AccountDetails
    )

    val currentRoute = navHostController
        .currentBackStackEntryAsState()?.value?.destination?.route

    BottomNavigation() {
        bottomNavItems.forEach { screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                onClick = { navHostController.navigate(screen.route) },
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.title) },
                label = { Text(text = screen.title) },
                alwaysShowLabel = true
            )
        }
    }
}

@Composable
fun TopBar(navHostController: NavHostController) {
    TopAppBar(
        title = {
            Text(text = "Banking App")
        },
        //Provide the navigation Icon ( Icon on the left to toggle drawer)
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Menu",
                modifier = Modifier.clickable(onClick = {navHostController.navigateUp()})
            )
        }
    )
}

