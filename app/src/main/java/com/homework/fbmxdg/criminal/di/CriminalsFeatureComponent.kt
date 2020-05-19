package com.homework.fbmxdg.criminalList.di

import com.homework.fbmxdg.criminalList.CreateCriminalFragment
import com.homework.fbmxdg.criminalList.CriminalsFragment
import com.homework.fbmxdg.criminalList.di.scope.CriminalsScope
import dagger.Subcomponent

@CriminalsScope
@Subcomponent(modules = [CriminalsFeatureModule::class])
interface CriminalsFeatureComponent {

    fun inject(criminalsActivity: CriminalsFragment)

    fun injectCreateCriminal(criminalFragment: CreateCriminalFragment)
}
