package com.ekachandra.core.data.repository

import com.ekachandra.core.data.NetworkBoundResource
import com.ekachandra.core.data.Resource
import com.ekachandra.core.data.source.remote.RemoteDataSource
import com.ekachandra.core.data.source.remote.network.ApiResponse
import com.ekachandra.core.data.source.remote.response.LoanResponse
import com.ekachandra.core.domain.model.Loan
import com.ekachandra.core.domain.repository.ILoanRepository
import com.ekachandra.core.utils.LoanDataMapper
import kotlinx.coroutines.flow.Flow

class LoanRepository(
    private val remoteDataSource: RemoteDataSource,
) : ILoanRepository {
    override fun getLoans(): Flow<Resource<List<Loan>>> =
        object : NetworkBoundResource<List<Loan>, LoanResponse>() {
            override fun loadFromNetwork(data: LoanResponse): Flow<List<Loan>> {
                return LoanDataMapper.mapResponseToDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<LoanResponse>> {
                return remoteDataSource.getLoans()
            }
        }.asFlow()
}