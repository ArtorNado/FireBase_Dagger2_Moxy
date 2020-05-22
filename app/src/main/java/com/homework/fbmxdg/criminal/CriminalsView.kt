package com.homework.fbmxdg.criminalList

import com.homework.fbmxdg.service.dataBase.models.Criminal
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface CriminalsView : MvpView {

    fun setAdapter(list: List<Criminal>)
}
