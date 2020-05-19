package com.homework.fbmxdg.signIn.di

import com.homework.fbmxdg.signIn.di.scope.SignInScope
import com.homework.fbmxdg.signIn.SignInActivity
import dagger.Subcomponent

@SignInScope
@Subcomponent(modules = [SignInFeatureModule::class])
interface SignInFeatureComponent {

    fun inject(signInActivity: SignInActivity)
}
