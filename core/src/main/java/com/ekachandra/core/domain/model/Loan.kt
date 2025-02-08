package com.ekachandra.core.domain.model

import android.os.Parcelable
import com.ekachandra.core.data.source.remote.response.DocumentsItem
import com.ekachandra.core.data.source.remote.response.RepaymentSchedule
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Loan(
    val id: String? = null,
    val borrowerName: String? = null,
    val borrowerEmail: String? = null,
    val loanAmount: Double? = null,
    val interestRate: Double? = null,
    val term: Int? = null,
    val purpose: String? = null,
    val riskRating: String? = null,
    val creditScore: Int? = null,
    val collateralType: String? = null,
    val collateralValue: Double? = null,
    val repaymentSchedule: @RawValue RepaymentSchedule? = null,
    val documents: @RawValue List<DocumentsItem?>? = null,
) : Parcelable
