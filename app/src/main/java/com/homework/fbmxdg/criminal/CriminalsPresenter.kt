package com.homework.fbmxdg.criminalList

import android.util.Log
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
class CriminalsPresenter @Inject constructor(
    private val criminalsRepository: CriminalsRepository
) : MvpPresenter<CriminalsView>() {

    fun getData(collection: String) {
        presenterScope.launch {
            withContext(Dispatchers.IO) {
                criminalsRepository.getData(collection)
            }.let {
                it.addOnSuccessListener {
                    val list = ArrayList<Criminal>()
                    for (document in it) {
                        Log.e("RESULT_GET", "${document.id} => ${document.data}")
                        list.add(
                            Criminal(
                                document.data.getValue("firstName").toString(),
                                document.data.getValue("secondName").toString(),
                                document.data.getValue("country").toString()
                            )
                        )

                    }
                    viewState.setAdapter(list)
                }
            }
        }
    }

    fun addButtonClick() {
        viewState.navigateToCreateCriminal()
    }
}
