package com.homework.fbmxdg.passwordLess.repository

import com.homework.fbmxdg.passwordLess.repository.interfaces.PasswordLessRepository
import com.homework.fbmxdg.service.email.EmailService
import javax.inject.Inject

class PasswordLessRepositoryImpl @Inject constructor(
    private val emailService: EmailService
) : PasswordLessRepository {

    override fun sendPasswordReset(email: String) =
        emailService.sendResetPasswordOnEmail(email)

}
