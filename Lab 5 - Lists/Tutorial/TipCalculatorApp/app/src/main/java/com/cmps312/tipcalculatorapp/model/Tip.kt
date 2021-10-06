package com.cmps312.tipcalculatorapp.model

import java.text.DecimalFormat

//"Good" "Okay" "Amaizing"
class Tip(
    var amount: Double = 0.0,
    var tipOption: String = "Good (15%)",
    var roundUp: Boolean = false,
) {

    //CTRL + D -> repeat a line
    private val tipPercentage = when (tipOption) {
        "Okay (10%)" -> 0.1
        "Good (15%)" -> 0.15
        "Amazing (20%)" -> 0.20
        else -> 0.0
    }

    val tipAmount: String = DecimalFormat("#.##")
        .format(if (roundUp) kotlin.math.ceil(tipPercentage * amount) else tipPercentage * amount)
}