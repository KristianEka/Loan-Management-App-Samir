package com.ekachandra.core.domain.usecase

import com.ekachandra.core.data.Resource
import com.ekachandra.core.data.repository.LoanRepository
import com.ekachandra.core.domain.model.Loan
import kotlinx.coroutines.flow.Flow

class LoanInteractor(
    private val loanRepository: LoanRepository
) : LoanUseCase {
    override fun getLoans(): Flow<Resource<List<Loan>>> {
        return loanRepository.getLoans()
    }
}