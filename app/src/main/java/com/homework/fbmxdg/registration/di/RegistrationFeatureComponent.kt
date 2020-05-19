package com.homework.fbmxdg.registration.di

import com.homework.fbmxdg.registration.RegistrationActivity
import com.homework.fbmxdg.registration.di.scope.RegistrationScope
import dagger.Subcomponent

@RegistrationScope
@Subcomponent(modules = [RegistrationFeatureModule::class])
interface RegistrationFeatureComponent {

    fun inject(registrationActivity: RegistrationActivity)
}
