package com.ekachandra.core.domain.model

import com.ekachandra.core.data.source.remote.response.DocumentsItem
import com.ekachandra.core.data.source.remote.response.RepaymentSchedule

data class Loan(
    val borrowerName: String? = null,
    val borrowerEmail: String? = null,
    val loanAmount: Int? = null,
    val interestRate: Double? = null,
    val term: Int? = null,
    val purpose: String? = null,
    val riskRating: String? = null,
    val creditScore: Int? = null,
    val collateralType: String? = null,
    val collateralValue: Int? = null,
    val repaymentSchedule: RepaymentSchedule? = null,
    val documents: List<DocumentsItem?>? = null,
)
