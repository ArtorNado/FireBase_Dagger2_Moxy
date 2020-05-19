package com.homework.fbmxdg.criminalList

import com.homework.fbmxdg.criminalList.di.scope.CriminalsScope
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@CriminalsScope
@AddToEndSingle
interface CriminalsCreateView: MvpView {

    fun navigateBack()
}
