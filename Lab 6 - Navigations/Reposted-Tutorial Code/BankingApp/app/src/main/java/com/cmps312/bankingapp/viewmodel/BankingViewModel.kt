package com.cmps312.bankingapp.viewmodel

import androidx.lifecycle.ViewModel
import com.cmps312.bankingapp.model.AccountRepository
import com.cmps312.bankingapp.model.Transfer

class BankingViewModel : ViewModel() {
    private var transfers = mutableListOf<Transfer>()

    fun addTransfer(transfer: Transfer): Int {
        val transferId = transfers.maxOfOrNull { it.transferId } ?: 1
        transfers.add(transfer)
        return transferId
    }

    fun getTransfer(transferId: Int) = transfers.find { it.transferId == transferId }
}