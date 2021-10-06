package com.cmps312.bankingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cmps312.bankingapp.common.getCurrentRoute
import com.cmps312.bankingapp.ui.theme.BankingAppTheme
import com.cmps312.bankingapp.views.MyNavHost
import com.cmps312.bankingapp.views.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navHostController = rememberNavController()
    Scaffold(
        topBar = { TopBar(navHostController) },
        bottomBar = { BottomBar(navHostController) }
    ) {
        MyNavHost(navHostController)
    }
}

@Composable
fun BottomBar(navHostController: NavController) {
    val bottomNavItems = listOf(
        Screen.Home, Screen.FundTransfer, Screen.AccountDetails
    )
    var currentRoute = getCurrentRoute(navHostController)

    BottomNavigation() {
        bottomNavItems.forEach { screen ->
            BottomNavigationItem(
                selected = screen.route == currentRoute,
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
        title = { Text("Banking App") },
        navigationIcon = {
            Icon(imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back Icon",
                modifier = Modifier.clickable {
                    navHostController.popBackStack()
                })
        }
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BankingAppTheme {
        MyApp()
    }
}