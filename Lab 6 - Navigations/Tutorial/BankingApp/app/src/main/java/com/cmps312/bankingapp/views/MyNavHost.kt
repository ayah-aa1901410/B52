package com.cmps312.bankingapp.views

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

//Todo implement the Nav Host

@Composable
fun MyNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) { Home() }
        composable(
            route = Screen.Confirmation.route + "/{transferId}",
            arguments = listOf(
                navArgument(name = "transferId") { type = NavType.IntType }
            )

        ) { backstack ->
            backstack.arguments?.getInt("transferId")?.let { transferId ->
                Confirmation(transferId, navHostController)
            }

        }
        composable(route = Screen.FundTransfer.route) {
            FundTransferScreen(navHostController, onTransferAdded = { transferId ->
                Log.d("Transfer ID", "MyNavHost: $transferId")
                navHostController.navigate(Screen.Confirmation.route + "/$transferId")
            })
        }
        composable(route = Screen.AccountDetails.route) { AccountDetails(navHostController) }
    }
}
