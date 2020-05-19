package com.homework.fbmxdg.signIn

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface SignInView: MvpView {

    fun setResult(text: String)

    fun openGoogleActivity()

    fun navigateToRegistrPage()

    fun navigateToResetPage()

    fun navigateToList()
}
