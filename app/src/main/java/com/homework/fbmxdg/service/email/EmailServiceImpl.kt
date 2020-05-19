package com.homework.fbmxdg.service.email

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class EmailServiceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : EmailService {

    var result: String? = null

    override fun createAccount(email: String, password: String) =
        auth.createUserWithEmailAndPassword(email, password)

    override fun signIn(email: String, password: String) =
        auth.signInWithEmailAndPassword(email, password)

    override fun sendResetPasswordOnEmail(email: String) =
        auth.sendPasswordResetEmail(email)

}
