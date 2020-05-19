package com.homework.fbmxdg.app.di

import com.homework.fbmxdg.app.scope.ApplicationScope
import com.homework.fbmxdg.containerActivity.di.ContainerFeatureComponent
import com.homework.fbmxdg.criminalList.di.CriminalsFeatureComponent
import com.homework.fbmxdg.passwordLess.di.PasswordLessFeatureComponent
import com.homework.fbmxdg.registration.di.RegistrationFeatureComponent
import com.homework.fbmxdg.service.di.*
import com.homework.fbmxdg.signIn.di.SignInFeatureComponent
import dagger.Component

@ApplicationScope
@Component(modules = [FirebaseModule::class, EmailModule::class, GoogleModule::class,
    PhoneModule::class, DataBaseModule::class])
interface AppComponent {

    fun provideSignInFeatureComponent(): SignInFeatureComponent

    fun provideRegistrationFeatureComponent(): RegistrationFeatureComponent

    fun providePasswordLessFeatureComponent(): PasswordLessFeatureComponent

    fun provideCriminalsFeatureComponent(): CriminalsFeatureComponent

    fun provideContainerFeatureComponent(): ContainerFeatureComponent

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

    }
}
