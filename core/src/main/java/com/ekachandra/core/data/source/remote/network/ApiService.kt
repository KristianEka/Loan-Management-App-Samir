package com.ekachandra.core.data.source.remote.network

import com.ekachandra.core.data.source.remote.response.LoanResponseItem
import retrofit2.http.GET

interface ApiService {
    @GET("api/json/loans.json")
    suspend fun getLoans(): List<LoanResponseItem>
}