package com.homework.fbmxdg.criminalList.repository

import com.homework.fbmxdg.criminalList.CriminalsCreateView
import com.homework.fbmxdg.criminalList.di.scope.CriminalsScope
import com.homework.fbmxdg.criminalList.repository.interfaces.CriminalsRepository
import com.homework.fbmxdg.service.dataBase.models.Criminal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

@CriminalsScope
@InjectViewState
class CreateCriminalPresenter @Inject constructor(
    private val criminalsRepository: CriminalsRepository
) : MvpPresenter<CriminalsCreateView>() {

    fun addCriminal(criminal: Criminal, collection: String) {
        presenterScope.launch {
            withContext(Dispatchers.IO) {
                criminalsRepository.setData(criminal, collection)
            }.let {
                viewState.navigateBack()
            }
        }
    }
}
