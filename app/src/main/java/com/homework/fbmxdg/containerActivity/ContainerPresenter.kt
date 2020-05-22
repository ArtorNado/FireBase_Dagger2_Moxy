package com.homework.fbmxdg.containerActivity

import com.homework.fbmxdg.containerActivity.di.scope.ContainerScope
import com.homework.fbmxdg.screen.Screens
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@ContainerScope
@InjectViewState
class ContainerPresenter @Inject constructor(
    private val router: Router
) : MvpPresenter<ContainerView>() {

    fun initStartFragment(){
        router.navigateTo(Screens.CriminalsScreen)
    }
    fun addOptionItemClick(){
        router.replaceScreen(Screens.CreateCriminalsScreen)
    }

    fun goNextContainerClick(){
        router.replaceScreen(Screens.ContainerNuiScreen)
    }
}
