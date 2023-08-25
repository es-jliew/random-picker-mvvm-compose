package com.example.tickclickpick.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { androidContext().applicationContext }
}