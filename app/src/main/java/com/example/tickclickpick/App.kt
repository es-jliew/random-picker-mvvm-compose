package com.example.tickclickpick

import android.app.Application
import com.example.tickclickpick.db.ObjectBox
import com.example.tickclickpick.di.appModule
import com.example.tickclickpick.di.repositoryModule
import com.example.tickclickpick.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)
        startKoin {
            androidContext(this@App)
            modules(appModule, repositoryModule, viewModelModule)
        }
    }
}