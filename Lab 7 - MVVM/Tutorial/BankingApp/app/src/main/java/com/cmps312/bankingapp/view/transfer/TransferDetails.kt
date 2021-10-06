package com.cmps312.bankingapp.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import com.cmps312.bankingapp.model.Transfer
import com.cmps312.bankingapp.viewmodel.BankingViewModel

//Todo add the navigation
@Composable
fun TransferDetails(onSubmit: () -> Unit) {
    val bankingViewModel =
        viewModel<BankingViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    val selectedTransfer = bankingViewModel.selectedTransfer
//    val selectedTransfer = Transfer("Abdulahi", 1222.0,
//        "Rayan", "123123")
    // ToDo: again
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
//        .offset(y = 200.dp),
            ,
        elevation = 16.dp) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            selectedTransfer.apply {
                Text(text = "From Account Number : ${fromAccountNo}", Modifier.padding(10.dp))
                Text(text = "Amount Transferred:${amount} QR", Modifier.padding(10.dp))
                Text(text = "Beneficiary Account Number: ${beneficiaryAccountNo}",
                    Modifier.padding(10.dp))
                Text(text = "Beneficiary Name: ${beneficiaryName}", Modifier.padding(10.dp))

                Button(
                    onClick = {
                        onSubmit()
                    },
                    modifier = Modifier.align(
                        Alignment.CenterHorizontally
                    )) {
                    Text(text = "OK")
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewTransferDetails(){
    TransferDetails(){

    }
}