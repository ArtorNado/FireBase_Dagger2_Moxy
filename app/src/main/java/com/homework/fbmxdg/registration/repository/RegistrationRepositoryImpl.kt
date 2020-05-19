package com.homework.fbmxdg.registration.repository

import com.homework.fbmxdg.registration.repository.interfaces.RegistrationRepository
import com.homework.fbmxdg.service.email.EmailService
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val emailService: EmailService
): RegistrationRepository {

    override fun registration(email: String, password: String) =
        emailService.createAccount(email, password)


}
