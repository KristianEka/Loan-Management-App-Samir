package com.ekachandra.loanmanagementapp

import android.app.Application
import com.ekachandra.core.di.networkModule
import com.ekachandra.core.di.repositoryModule
import com.ekachandra.loanmanagementapp.di.useCaseModule
import com.ekachandra.loanmanagementapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}