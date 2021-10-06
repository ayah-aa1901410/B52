package com.cmps312.bankingapp.model

//import kotlinx.android.parcel.Parcelize
//
//@Parcelize
data class Transfer(
    var transferId: Int = 0,
    var fromAccountNo: String? = null,
    var beneficiaryName: String? = null,
    var beneficiaryAccountNo: String? = null,
    var amount: Double = 0.0,
)