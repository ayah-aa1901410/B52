package com.cmps312.bankingapp.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route : String, val title: String, val icon : ImageVector){
    object TransferList : Screen(route = "transferList", title = "Transfers",
        icon = Icons.Outlined.AccountBalance)

    object TransferDetail : Screen(route = "transferDetail", title = "Transfer Details",
        icon = Icons.Outlined.Details)

    object FundTransfer : Screen(route = "fundTransfer", title = "Fund Transfer",
        icon = Icons.Outlined.Money)

    object Beneficiary : Screen(route = "selectBeneficiary", title = "Select Beneficiary",
        icon = Icons.Outlined.PersonAdd)

  object TransferConfirmation : Screen(route = "transferConfirmation", title = "Transfer Confirmation",
        icon = Icons.Outlined.PersonAdd)

    object AccountDetails : Screen(route = "accountDetails.kt", title = "Account Details",
        icon = Icons.Outlined.Person)
}
