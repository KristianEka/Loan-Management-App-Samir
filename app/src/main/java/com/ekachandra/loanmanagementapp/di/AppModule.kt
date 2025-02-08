package com.ekachandra.loanmanagementapp.di

import com.ekachandra.core.domain.usecase.LoanInteractor
import com.ekachandra.core.domain.usecase.LoanUseCase
import com.ekachandra.loanmanagementapp.presentation.loan.LoanViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<LoanUseCase> { LoanInteractor(get()) }
}

val viewModelModule = module {
    viewModel { LoanViewModel(get()) }
}