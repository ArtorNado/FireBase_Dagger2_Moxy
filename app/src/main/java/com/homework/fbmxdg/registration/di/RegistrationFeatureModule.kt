package com.homework.fbmxdg.registration.di

import com.homework.fbmxdg.registration.di.scope.RegistrationScope
import com.homework.fbmxdg.registration.repository.RegistrationRepositoryImpl
import com.homework.fbmxdg.registration.repository.interfaces.RegistrationRepository
import dagger.Module
import dagger.Provides

@Module
class RegistrationFeatureModule {

    @RegistrationScope
    @Provides
    fun provideRegistrationRepository(registrationRepository: RegistrationRepositoryImpl):
            RegistrationRepository = registrationRepository
}
