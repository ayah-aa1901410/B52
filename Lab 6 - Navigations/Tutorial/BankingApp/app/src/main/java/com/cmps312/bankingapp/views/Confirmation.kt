package com.cmps312.bankingapp.views

import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.cmps312.bankingapp.viewmodel.BankingViewModel

//Todo add the navigation
@Composable
fun Confirmation(transferId: Int, navController: NavHostController) {

    //Todo [Please ignore this code for now, you will understand it better late this week]
    val bankingViewModel =
        viewModel<BankingViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    val transfer = bankingViewModel.getTransfer(transferId)
    val context = LocalContext.current

    Toast.makeText(context, "$transferId", Toast.LENGTH_SHORT).show()

    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxSize(), elevation = 16.dp) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {

            Log.d("Transfer Object", "Confirmation: ${transfer?.transferId} ${transfer?.fromAccountNo}")
            Text(text = "From Account Number : ${transfer?.fromAccountNo}")
            Text(text = "Amount Transferred:${transfer?.amount} QR")
            Text(text = "Beneficiary Account Number: ${transfer?.beneficiaryAccountNo}")
            Text(text = "Beneficiary name: ${transfer?.beneficiaryName}")


            Button(
                onClick = {
                    Toast.makeText(context, "Transferred Successfully", Toast.LENGTH_SHORT).show()
                    //todo to navigate back to home
                    navController.navigate(Screen.Home.route)

                },
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                )
            ) {
                Text(text = "Confirm")
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConfirmation() {
//    Confirmation(Transfer("12345","Ali","12345",123.7))
}