package com.homework.fbmxdg.passwordLess

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface PasswordLessView : MvpView {

    fun setResult(text: String)
}

