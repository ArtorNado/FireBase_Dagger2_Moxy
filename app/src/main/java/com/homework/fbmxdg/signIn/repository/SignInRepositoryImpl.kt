package com.homework.fbmxdg.signIn.repository

import android.content.Intent
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.homework.fbmxdg.service.email.EmailService
import com.homework.fbmxdg.service.google.GoogleService
import com.homework.fbmxdg.service.phone.PhoneService
import com.homework.fbmxdg.signIn.repository.interfaces.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val emailService: EmailService,
    private val googleService: GoogleService,
    private val phoneService: PhoneService
) : SignInRepository {

    override fun singIn(email: String, password: String) =
        emailService.signIn(email, password)


    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        rc_sign_in: Int
    ) = googleService.onActivityResult(requestCode, resultCode, data, rc_sign_in)


    override fun startPhoneNumberVerification(phoneNumber: String) {
        phoneService.startPhoneNumberVerification(phoneNumber)
    }

    override fun verifyPhoneNumberWithCode(code: String): Task<AuthResult> =
        phoneService.verifyPhoneNumberWithCode(code)


}
