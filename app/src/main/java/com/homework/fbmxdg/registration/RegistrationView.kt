package com.homework.fbmxdg.registration

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface RegistrationView : MvpView {

    fun setResult(text: String)

}
