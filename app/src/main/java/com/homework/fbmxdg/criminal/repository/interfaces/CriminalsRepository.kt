package com.homework.fbmxdg.criminalList.repository.interfaces

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.homework.fbmxdg.service.dataBase.models.Criminal

interface CriminalsRepository {

    fun setData(criminal: Criminal, collection: String)

    fun getData(collection: String): Task<QuerySnapshot>
}
