package com.homework.fbmxdg.service.phone

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.PhoneAuthCredential

interface PhoneService {

    fun startPhoneNumberVerification(phoneNumber: String)

    fun verifyPhoneNumberWithCode(code: String): Task<AuthResult>

    fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential): Task<AuthResult>
}
