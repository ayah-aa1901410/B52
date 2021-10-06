package com.cmps312.bankingapp.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.cmps312.bankingapp.model.Transfer
import com.cmps312.bankingapp.repository.BankRepository

//hold all the data of the screens
class BankingViewModel(appContext: Application) : AndroidViewModel(appContext) {
    val bankRepository = BankRepository(appContext)

    //improvements
    val accounts by lazy { bankRepository.getAccounts() }
    val beneficiaries by lazy { bankRepository.getBeneficiaries() }
    val transfers = mutableStateListOf<Transfer>(*bankRepository.getTransfers().toTypedArray())

    var selectedTransfer by mutableStateOf(Transfer())

    lateinit var newTransfer : Transfer

    fun setTransferFromDetails(fromAccount: String, amount: Double){
        newTransfer = Transfer(fromAccount, amount)
    }

    fun setBeneficiaryDetails(beneficiaryName: String, beneficiaryAccountNo: String){
        newTransfer.beneficiaryName = beneficiaryName
        newTransfer.beneficiaryAccountNo = beneficiaryAccountNo
    }

    fun addTranser(newTransfer: Transfer) {
        transfers.add(newTransfer)
    }
}