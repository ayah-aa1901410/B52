package com.cmps312.bankingapp.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cmps312.bankingapp.view.account.AccountDetails
import com.cmps312.bankingapp.view.transfer.Beneficiary
import com.cmps312.bankingapp.view.transfer.FundTransfer
import com.cmps312.bankingapp.view.transfer.TransferConfirmation

@Composable
fun AppNavHost(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Screen.TransferList.route) {
        composable(route = Screen.TransferDetail.route) {
            TransferDetails(onSubmit = {
                navHostController.navigate(Screen.TransferList.route)
            })
        }
        composable(route = Screen.TransferList.route) {
            TransferList(onTransferSelected = {
                navHostController.navigate(Screen.TransferDetail.route)
            })
        }

        composable(route = Screen.FundTransfer.route) {
            FundTransfer(onFundTransfer = {
                navHostController.navigate(Screen.Beneficiary.route)
            })
        }

        composable(route = Screen.AccountDetails.route) { AccountDetails() }
        composable(route = Screen.Beneficiary.route) { Beneficiary(onSelectedBeneficiary = {
            navHostController.navigate(Screen.TransferConfirmation.route)
        })}

        composable(route = Screen.TransferConfirmation.route) { TransferConfirmation(onTransferConfirmation = {
            navHostController.navigate(Screen.TransferList.route)
        })}
    }

}
