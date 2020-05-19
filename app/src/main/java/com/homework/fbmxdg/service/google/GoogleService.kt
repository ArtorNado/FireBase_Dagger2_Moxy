package com.homework.fbmxdg.service.google

import android.content.Intent
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface GoogleService {

    fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        rcSign: Int
    ): Task<AuthResult>
}
