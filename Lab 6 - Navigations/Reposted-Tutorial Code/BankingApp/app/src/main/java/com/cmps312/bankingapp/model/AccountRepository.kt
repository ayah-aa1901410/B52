package com.cmps312.bankingapp.model

object AccountRepository {
    private val accounts = listOf(
        Account(123, "Abbas", "Ibn Firnas", "Saving", 5000.5),
        Account(234, "Juha", "Dahak", "Current", 20000.4),
    )

    fun getAccount(accountId: Int) = accounts.find { it.accountId == accountId }
}