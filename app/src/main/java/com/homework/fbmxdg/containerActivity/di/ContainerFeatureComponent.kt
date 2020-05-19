package com.homework.fbmxdg.containerActivity.di

import com.homework.fbmxdg.containerActivity.ContainerActivity
import com.homework.fbmxdg.containerActivity.di.scope.ContainerScope
import dagger.Subcomponent

@ContainerScope
@Subcomponent(modules = [ContainerFeatureModule::class])
interface ContainerFeatureComponent {

    fun inject(containerActivity: ContainerActivity)

}
