package com.ekachandra.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

//data class LoanResponse(
//    val loanResponse: List<LoanResponseItem?>? = null
//)

data class InstallmentsItem(

    @field:SerializedName("amountDue")
    val amountDue: Double? = null,

    @field:SerializedName("dueDate")
    val dueDate: String? = null
)

data class Collateral(

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("value")
    val value: Double? = null
)

data class RepaymentSchedule(

    @field:SerializedName("installments")
    val installments: List<InstallmentsItem?>? = null
)

data class LoanResponseItem(

    @field:SerializedName("interestRate")
    val interestRate: Double? = null,

    @field:SerializedName("amount")
    val amount: Double? = null,

    @field:SerializedName("purpose")
    val purpose: String? = null,

    @field:SerializedName("documents")
    val documents: List<DocumentsItem?>? = null,

    @field:SerializedName("borrower")
    val borrower: Borrower? = null,

    @field:SerializedName("term")
    val term: Int? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("collateral")
    val collateral: Collateral? = null,

    @field:SerializedName("repaymentSchedule")
    val repaymentSchedule: RepaymentSchedule? = null,

    @field:SerializedName("riskRating")
    val riskRating: String? = null
)

data class DocumentsItem(

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class Borrower(

    @field:SerializedName("creditScore")
    val creditScore: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("email")
    val email: String? = null
)
