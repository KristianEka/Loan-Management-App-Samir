package com.ekachandra.loanmanagementapp.presentation.loan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ekachandra.core.domain.usecase.LoanUseCase

class LoanViewModel(
    private val loanUseCase: LoanUseCase
) : ViewModel() {

    fun getLoans() = loanUseCase.getLoans().asLiveData()

}