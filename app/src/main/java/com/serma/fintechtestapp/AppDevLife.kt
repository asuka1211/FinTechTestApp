package com.serma.fintechtestapp

import android.app.Application
import com.serma.fintechtestapp.di.AppComponent
import com.serma.fintechtestapp.di.DaggerAppComponent

class AppDevLife : Application() {

    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
    }

    fun getAppComponent(): AppComponent {
        return appComponent ?: DaggerAppComponent.factory().create(applicationContext).also {
            appComponent = it
        }
    }
}