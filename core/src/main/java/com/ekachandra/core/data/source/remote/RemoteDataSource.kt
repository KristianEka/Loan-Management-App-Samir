package com.ekachandra.core.data.source.remote

import com.ekachandra.core.data.source.remote.network.ApiResponse
import com.ekachandra.core.data.source.remote.network.ApiService
import com.ekachandra.core.data.source.remote.response.LoanResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(
    private val apiService: ApiService,
) {
    fun getLoans(): Flow<ApiResponse<LoanResponse>> {
        return flow {
            try {
                val response = apiService.getLoans()
                val dataArray = response.loanResponse
                if (dataArray.isNullOrEmpty()) {
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Success(response))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}