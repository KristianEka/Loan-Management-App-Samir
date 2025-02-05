package com.ekachandra.core.domain.usecase

import com.ekachandra.core.data.Resource
import com.ekachandra.core.domain.model.Loan
import kotlinx.coroutines.flow.Flow

interface LoanUseCase {
    fun getLoans(): Flow<Resource<List<Loan>>>
}