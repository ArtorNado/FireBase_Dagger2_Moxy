package com.homework.fbmxdg.registration.repository.interfaces

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface RegistrationRepository {

    fun registration(email: String, password: String): Task<AuthResult>
}
