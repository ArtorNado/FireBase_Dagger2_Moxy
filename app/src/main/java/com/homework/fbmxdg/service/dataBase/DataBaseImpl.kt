package com.homework.fbmxdg.service.dataBase

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.homework.fbmxdg.service.dataBase.models.Criminal
import javax.inject.Inject

class DataBaseImpl @Inject constructor(
    private val db: FirebaseFirestore
) : DataBase {


    override fun setCriminal(criminal: Criminal, collection: String) {
        db.collection(collection)
            .add(criminal)
            .addOnSuccessListener { documentReference ->
                Log.d("RESULT_SET", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("RESULT_SET", "Error adding document", e)
            }
    }

    override fun getCriminal(collection: String): Task<QuerySnapshot> = db.collection(collection)
        .get()


}
