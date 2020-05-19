package com.homework.fbmxdg.signIn.repository.interfaces

import android.content.Intent
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface SignInRepository {

    fun singIn(email: String, password: String): Task<AuthResult>

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?, rcSignIn: Int): Task<AuthResult>

    fun startPhoneNumberVerification(phoneNumber: String)

    fun verifyPhoneNumberWithCode(code: String): Task<AuthResult>

}
