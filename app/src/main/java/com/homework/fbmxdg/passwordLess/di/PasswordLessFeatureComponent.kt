package com.homework.fbmxdg.passwordLess.di

import com.homework.fbmxdg.passwordLess.PasswordLessActivity
import com.homework.fbmxdg.passwordLess.di.scope.PasswordLessScope
import dagger.Subcomponent

@PasswordLessScope
@Subcomponent(modules = [PasswordLessFeatureModule::class])
interface PasswordLessFeatureComponent {

    fun inject(passwordLessActivity: PasswordLessActivity)
}
