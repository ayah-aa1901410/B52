package com.cmps312.bankingapp.view.transfer

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.bankingapp.viewmodel.BankingViewModel

//Todo add the navigation
@Composable
// ToDo: pass the transfer id to this route
fun TransferConfirmation(onTransferConfirmation: () -> Unit) {
    val bankingViewModel =
        viewModel<BankingViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    //Todo this to BankViewModel
    val newTransfer = bankingViewModel.newTransfer

    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .offset(y = 200.dp),
        elevation = 16.dp) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            newTransfer.apply {
                Text(text = "From Account Number : ${fromAccountNo}", Modifier.padding(10.dp))
                Text(text = "Amount Transferred:${amount} QR", Modifier.padding(10.dp))
                Text(text = "Beneficiary Account Number: ${beneficiaryAccountNo}",
                    Modifier.padding(10.dp))
                Text(text = "Beneficiary Name: ${beneficiaryName}", Modifier.padding(10.dp))

                Row(modifier = Modifier.padding(10.dp)) {
                    Button(
                        onClick = {
                            onTransferConfirmation()
                        },

                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(horizontal = 10.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red)) {
                        Text(text = "Cancel", color = Color.White)
                    }
                    Button(
                        onClick = {
                            //Todo: this is just a confirmation
                            bankingViewModel.addTranser(newTransfer)
                            onTransferConfirmation()
                        },
                        modifier = Modifier.align(
                            Alignment.CenterVertically
                        )) {
                        Text(text = "Confirm")
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConfirmation() {
//    Confirmation(Transfer("12345","Ali","12345",123.7))
}