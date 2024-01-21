package com.essoft.randompicker

import android.app.Application
import com.essoft.randompicker.db.ObjectBox
import com.essoft.randompicker.di.appModule
import com.essoft.randompicker.di.repositoryModule
import com.essoft.randompicker.di.viewModelModule
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