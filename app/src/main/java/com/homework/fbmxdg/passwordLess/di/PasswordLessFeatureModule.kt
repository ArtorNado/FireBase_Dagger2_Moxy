package com.homework.fbmxdg.passwordLess.di

import com.homework.fbmxdg.passwordLess.di.scope.PasswordLessScope
import com.homework.fbmxdg.passwordLess.repository.PasswordLessRepositoryImpl
import com.homework.fbmxdg.passwordLess.repository.interfaces.PasswordLessRepository
import dagger.Module
import dagger.Provides

@Module
class PasswordLessFeatureModule {

    @PasswordLessScope
    @Provides
    fun providePasswordLessRepository(passwordLessRepository: PasswordLessRepositoryImpl):
            PasswordLessRepository = passwordLessRepository
}
