package com.ekachandra.core.domain.repository

import com.ekachandra.core.data.Resource
import com.ekachandra.core.domain.model.Loan
import kotlinx.coroutines.flow.Flow

interface ILoanRepository {
    fun getLoans(): Flow<Resource<List<Loan>>>
}