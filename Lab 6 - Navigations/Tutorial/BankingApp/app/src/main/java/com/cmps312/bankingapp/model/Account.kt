package com.cmps312.bankingapp.model

data class Account(
    val accountId: Int,
    val firstName: String,
    val lastName: String,
    val accountType: String,
    val balance: Double,
)