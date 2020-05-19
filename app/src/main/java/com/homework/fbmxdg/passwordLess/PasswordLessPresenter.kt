package com.homework.fbmxdg.passwordLess

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.homework.fbmxdg.passwordLess.di.scope.PasswordLessScope
import com.homework.fbmxdg.passwordLess.repository.interfaces.PasswordLessRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

@PasswordLessScope
@InjectViewState
class PasswordLessPresenter @Inject constructor(
    private val passwordLessRepository: PasswordLessRepository,
    private val logs: FirebaseAnalytics
) : MvpPresenter<PasswordLessView>() {

    fun sendMessage(email: String) {
        logs.logEvent("RESET PASSWORD") {
            param("USER", email)
        }
        presenterScope.launch {
            withContext(Dispatchers.IO) {
                passwordLessRepository.sendPasswordReset(email)
            }.addOnCompleteListener() { result ->
                if (result.isSuccessful) viewState.setResult(result.toString())
                else viewState.setResult(result.exception.toString())
            }
        }
    }
}
