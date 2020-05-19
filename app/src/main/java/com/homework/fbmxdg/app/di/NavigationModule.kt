package com.homework.fbmxdg.app.di

import com.homework.fbmxdg.app.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class NavigationModule {

    private val cicerone: Cicerone<Router>

    init {
        cicerone = Cicerone.create()
    }

    @Provides
    @ApplicationScope
    fun provideRouter(): Router = cicerone.router


    @Provides
    @ApplicationScope
    fun provideNavigatorHolder(): NavigatorHolder = cicerone.navigatorHolder
}

