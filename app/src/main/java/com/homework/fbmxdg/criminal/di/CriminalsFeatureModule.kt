package com.homework.fbmxdg.criminalList.di

import com.homework.fbmxdg.criminalList.di.scope.CriminalsScope
import com.homework.fbmxdg.criminalList.repository.CriminalsRepositoryImpl
import com.homework.fbmxdg.criminalList.repository.interfaces.CriminalsRepository
import dagger.Module
import dagger.Provides

@Module
class CriminalsFeatureModule {

    @CriminalsScope
    @Provides
    fun provideCriminalsRepository(criminalsRepository: CriminalsRepositoryImpl): CriminalsRepository =
        criminalsRepository
}
