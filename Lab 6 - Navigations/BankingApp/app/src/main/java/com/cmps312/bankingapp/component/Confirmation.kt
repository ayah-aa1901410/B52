package com.cmps312.bankingapp.component

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.cmps312.bankingapp.model.Transfer

//Todo add the navigation
@Composable
fun Confirmation(transfer: Transfer) {
    val context = LocalContext.current
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxSize(), elevation = 16.dp) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {
            Text(text = "From Account Number : ${transfer.fromAccountNo}")
            Text(text = "Amount Transferred:${transfer.amount} QR")
            Text(text = "Beneficiary Account Number: ${transfer.beneficiaryAccountNo}")
            Text(text = "Beneficiary name: ${transfer.beneficiaryName}")
            Button(
                onClick = {
                    Toast.makeText(context, "Transferred Sucessfuly", Toast.LENGTH_SHORT).show()

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