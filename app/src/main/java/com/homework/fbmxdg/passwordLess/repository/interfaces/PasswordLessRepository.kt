package com.homework.fbmxdg.passwordLess.repository.interfaces

import com.google.android.gms.tasks.Task

interface PasswordLessRepository {

    fun sendPasswordReset(email: String): Task<Void>
}
