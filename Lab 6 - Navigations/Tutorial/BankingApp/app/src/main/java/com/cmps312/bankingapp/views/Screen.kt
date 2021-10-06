package com.cmps312.bankingapp.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen(route = "home", title = "Home", icon = Icons.Outlined.Home)
    object AccountDetails :
        Screen(route = "account", title = "Account Details", icon = Icons.Outlined.AccountBalance)

    object FundTransfer :
        Screen(route = "transfer", title = "Fund Transfer", icon = Icons.Outlined.Payments)

    object Confirmation : Screen(route = "confirmation",
        title = "Transfer Confirmation",
        icon = Icons.Outlined.ConfirmationNumber)
}
