package com.homework.fbmxdg.service.email

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface EmailService {

    fun createAccount(email: String, password: String): Task<AuthResult>

    fun signIn(email: String, password: String): Task<AuthResult>

    fun sendResetPasswordOnEmail(email: String): Task<Void>
}
