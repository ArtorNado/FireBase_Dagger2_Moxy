package com.homework.fbmxdg.service.di

import com.homework.fbmxdg.app.scope.ApplicationScope
import com.homework.fbmxdg.service.google.GoogleService
import com.homework.fbmxdg.service.google.GoogleServiceImpl
import dagger.Module
import dagger.Provides

@Module
class GoogleModule {

    @ApplicationScope
    @Provides
    fun provideGoogleService(googleService: GoogleServiceImpl): GoogleService = googleService

}
