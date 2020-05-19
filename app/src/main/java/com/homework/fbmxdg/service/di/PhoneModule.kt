package com.homework.fbmxdg.service.di

import com.homework.fbmxdg.app.scope.ApplicationScope
import com.homework.fbmxdg.service.phone.PhoneService
import com.homework.fbmxdg.service.phone.PhoneServiceImpl
import dagger.Module
import dagger.Provides

@Module
class PhoneModule {

    @ApplicationScope
    @Provides
    fun providePhoneService(phoneService: PhoneServiceImpl): PhoneService = phoneService
}
