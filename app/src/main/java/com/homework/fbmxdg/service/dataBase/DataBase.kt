package com.homework.fbmxdg.service.dataBase

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.homework.fbmxdg.service.dataBase.models.Criminal

interface DataBase {

    fun setCriminal(criminal: Criminal, collection: String)

    fun getCriminal(collection: String): Task<QuerySnapshot>
}
