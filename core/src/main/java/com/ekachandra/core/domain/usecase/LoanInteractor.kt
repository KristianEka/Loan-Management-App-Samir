package com.ekachandra.core.domain.usecase

import com.ekachandra.core.data.Resource
import com.ekachandra.core.domain.model.Loan
import com.ekachandra.core.domain.repository.ILoanRepository
import kotlinx.coroutines.flow.Flow

class LoanInteractor(
    private val loanRepository: ILoanRepository
) : LoanUseCase {
    override fun getLoans(): Flow<Resource<List<Loan>>> {
        return loanRepository.getLoans()
    }
}