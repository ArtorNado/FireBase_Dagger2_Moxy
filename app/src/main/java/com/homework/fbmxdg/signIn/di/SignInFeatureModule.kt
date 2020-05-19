package com.homework.fbmxdg.signIn.di

import com.homework.fbmxdg.signIn.di.scope.SignInScope
import com.homework.fbmxdg.signIn.repository.SignInRepositoryImpl
import com.homework.fbmxdg.signIn.repository.interfaces.SignInRepository
import dagger.Module
import dagger.Provides

@Module
class SignInFeatureModule {

    @SignInScope
    @Provides
    fun provideSignInRepository(signInRepository: SignInRepositoryImpl): SignInRepository = signInRepository

}
