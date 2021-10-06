package com.cmps312.bankingapp.component


import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cmps312.bankingapp.model.Transfer

//Todo : add the call back
@Composable
fun FundTransferScreen() {

    var fromAccount by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var beneficiaryName by remember { mutableStateOf("") }
    var beneficiaryAccountNo by remember { mutableStateOf("") }

    var context = LocalContext.current
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .fillMaxSize(), elevation = 16.dp) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Text(text = "Fund Transfer",
                Modifier
                    .align(
                        Alignment.CenterHorizontally)
                    .padding(16.dp), fontWeight = FontWeight.Bold)
            Divider()
            OutlinedTextField(value = fromAccount,
                onValueChange = { fromAccount = it },
                label = { Text(text = "From Account Number ") })

            OutlinedTextField(value = amount,
                onValueChange = { amount = it },
                label = { Text(text = "Amount ") })
            OutlinedTextField(value = beneficiaryName,
                onValueChange = { beneficiaryName = it },
                label = { Text(text = "Beneficiary Account Number ") })

            OutlinedTextField(value = beneficiaryAccountNo,
                onValueChange = { beneficiaryAccountNo = it },
                label = { Text(text = "Beneficiary Name ") })

            OutlinedButton(onClick = {
                if (fromAccount.isNotEmpty() &&
                    amount.isNotEmpty() &&
                    beneficiaryAccountNo.isNotEmpty()
                    && beneficiaryName.isNotEmpty()
                ) {
                    val transfer = Transfer();
                    transfer.amount = amount.toDouble()
                    transfer.beneficiaryAccountNo = beneficiaryAccountNo
                    transfer.beneficiaryName = beneficiaryName
                    transfer.fromAccountNo = fromAccount
                    Toast.makeText(context, "${transfer.toString()}", Toast.LENGTH_LONG).show()

                    //Todo add the navigation here

                } else {
                    Toast.makeText(context, "Please provide all the information",
                        Toast.LENGTH_SHORT).show()
                }
            },
                modifier = Modifier
                    .align(
                        Alignment.CenterHorizontally)
                    .padding(16.dp)) {
                Text(text = "Fund Transfer")
            }
        }
    }

}