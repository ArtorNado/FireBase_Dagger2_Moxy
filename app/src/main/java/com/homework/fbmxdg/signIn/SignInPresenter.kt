package com.homework.fbmxdg.signIn

import android.content.Intent
import com.homework.fbmxdg.signIn.di.scope.SignInScope
import com.homework.fbmxdg.signIn.repository.interfaces.SignInRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

@SignInScope
@InjectViewState
class SignInPresenter @Inject constructor(
    private val signInRepository: SignInRepository
) : MvpPresenter<SignInView>() {

    fun onLogInClick(email: String, password: String) {
        presenterScope.launch {
            withContext(Dispatchers.IO) {
                signInRepository.singIn(email, password)
            }.addOnCompleteListener() { task ->
                if (task.isSuccessful) viewState.navigateToList()
                else viewState.setResult(task.exception.toString())
            }
        }
    }

    fun signInWithGoogle() {
        presenterScope.launch {
            withContext(Dispatchers.IO) {
                viewState.openGoogleActivity()
            }
        }
    }

    fun registrButtonClick() {
        presenterScope.launch {
            withContext(Dispatchers.IO) {
                viewState.navigateToRegistrPage()
            }
        }
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?, rcSignIn: Int) {
        presenterScope.launch {
            withContext(Dispatchers.IO) {
                signInRepository.onActivityResult(requestCode, resultCode, data, rcSignIn)
            }.addOnCompleteListener() { task ->
                if (task.isSuccessful) viewState.navigateToList()
                else viewState.setResult(task.exception.toString())
            }
        }
    }

    fun verifyPhoneNumberWithCode(code: String) {
        presenterScope.launch {
            withContext(Dispatchers.IO) {
                signInRepository.verifyPhoneNumberWithCode(code)
            }.addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    viewState.navigateToList()
                } else {
                    viewState.setResult(task.exception.toString())
                }
            }
        }
    }

    fun startPhoneNumberVerification(phoneNumber: String) {
        presenterScope.launch {
            withContext(Dispatchers.IO) {
                signInRepository.startPhoneNumberVerification(phoneNumber)
            }
        }
    }

    fun resetButtonClick() {
        presenterScope.launch {
            withContext(Dispatchers.IO) {
                viewState.navigateToResetPage()
            }
        }
    }

}
