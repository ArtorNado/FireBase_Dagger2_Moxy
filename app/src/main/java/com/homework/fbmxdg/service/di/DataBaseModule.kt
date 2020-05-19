package com.homework.fbmxdg.service.di

import com.homework.fbmxdg.app.scope.ApplicationScope
import com.homework.fbmxdg.service.dataBase.DataBase
import com.homework.fbmxdg.service.dataBase.DataBaseImpl
import dagger.Module
import dagger.Provides

@Module
class DataBaseModule {

    @ApplicationScope
    @Provides
    fun provideDataBaseService(dataBase: DataBaseImpl): DataBase = dataBase
}
