package com.ekachandra.core.utils

import com.ekachandra.core.data.source.remote.response.LoanResponseItem
import com.ekachandra.core.domain.model.Loan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object LoanDataMapper {
    fun mapResponseToDomain(input: List<LoanResponseItem>): Flow<List<Loan>> {
        val loanList = ArrayList<Loan>()
        input.map {
            val loan = Loan(
                borrowerName = it.borrower?.name,
                borrowerEmail = it.borrower?.email,
                loanAmount = it.amount,
                interestRate = it.interestRate,
                term = it.term,
                purpose = it.purpose,
                riskRating = it.riskRating,
                creditScore = it.borrower?.creditScore,
                collateralType = it.collateral?.type,
                collateralValue = it.collateral?.value,
                repaymentSchedule = it.repaymentSchedule,
                documents = it.documents,
            )
            loanList.add(loan)
        }
        return flowOf(loanList)
    }
}