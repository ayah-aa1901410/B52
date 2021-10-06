package com.cmps312.tipcalculatorapp.view

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmps312.tipcalculatorapp.model.Tip
import com.cmps312.tipcalculatorapp.ui.theme.TipCalculatorAppTheme

@Composable
fun TipCalculatorScreen() {
    val tipOptions = listOf("Okay (10%)", "Good (15%)", "Amazing (20%)")
    var amount by remember { mutableStateOf("") }
    var roundUp by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(1) }

    Card(elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
        Column(modifier = Modifier
            .padding(30.dp)) {
            Text(text = "Tip Calculator",
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold)


            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                label = { Text(text = "Enter amount") })
            Spacer(modifier = Modifier.height(10.dp))

            tipOptions.forEachIndexed { index, option ->
                Row(modifier = Modifier.padding(10.dp)) {
                    RadioButton(selected = selectedOption == index,
                        onClick = { selectedOption = index })
                    Text(text = option)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row() {
                Text(text = "Round Up")
                Spacer(modifier = Modifier.width(3.dp))
                Switch(checked = roundUp, onCheckedChange = { roundUp = it })
            }

            if (amount.isNotEmpty()) {
                Text(text = "Total Amount = ${
                    Tip(amount.toDouble(), tipOptions[selectedOption], roundUp).tipAmount
                }")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMyDesign() {
    TipCalculatorAppTheme {
        TipCalculatorScreen()
    }
}