package com.homework.fbmxdg.criminalList.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.firestore.QuerySnapshot
import com.homework.fbmxdg.criminalList.repository.interfaces.CriminalsRepository
import com.homework.fbmxdg.service.dataBase.DataBase
import com.homework.fbmxdg.service.dataBase.models.Criminal
import javax.inject.Inject

class CriminalsRepositoryImpl @Inject constructor(
    private val dataBase: DataBase,
    private val logs: FirebaseAnalytics
) : CriminalsRepository {

    override fun setData(criminal: Criminal, collection: String) {
        logs.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
            param(FirebaseAnalytics.Param.ITEM_NAME, criminal.firstName)
        }
        dataBase.setCriminal(criminal, collection)
    }

    override fun getData(collection: String): Task<QuerySnapshot> = dataBase.getCriminal(collection)
}
