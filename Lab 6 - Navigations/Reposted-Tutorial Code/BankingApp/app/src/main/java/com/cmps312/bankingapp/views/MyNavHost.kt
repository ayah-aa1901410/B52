package com.cmps312.bankingapp.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cmps312.bankingapp.Screen

@Composable
fun MyNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) { Home() }
        composable(route = Screen.AccountDetail.route) { AccountDetails(navHostController) }
        composable(route = Screen.FundTransfer.route) { FundTransfer(navHostController, onTransferAdded = {
        }) }
        composable(route = Screen.Confirmation.route) { Confirmation(0, navHostController) }
    }
}