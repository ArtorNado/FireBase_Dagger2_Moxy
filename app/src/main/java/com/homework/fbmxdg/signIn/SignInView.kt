package com.homework.fbmxdg.signIn

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface SignInView: MvpView {

    fun setResult(text: String)

    fun signIn()

    fun openGoogleActivity()

    fun signInWithPhoneNumber()

    fun goToRegisr()

    fun navigateToProfile()

    fun navigateToResetPage()

    fun navigateToList()
}
