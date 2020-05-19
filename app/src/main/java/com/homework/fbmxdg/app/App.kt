package com.homework.fbmxdg.app

import android.app.Application
import com.homework.fbmxdg.app.di.AppComponent
import com.homework.fbmxdg.app.di.DaggerAppComponent
import moxy.MvpFacade

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        MvpFacade.init()
        appComponent = DaggerAppComponent.builder()
            .build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }

}
