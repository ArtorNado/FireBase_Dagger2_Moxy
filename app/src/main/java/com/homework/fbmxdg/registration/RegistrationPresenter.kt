package com.homework.fbmxdg.registration

import com.homework.fbmxdg.registration.di.scope.RegistrationScope
import com.homework.fbmxdg.registration.repository.interfaces.RegistrationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

@RegistrationScope
@InjectViewState
class RegistrationPresenter @Inject constructor(
    private val registrationRepository: RegistrationRepository
) : MvpPresenter<RegistrationView>() {

    fun registration(email: String, password: String) {
        presenterScope.launch {
            withContext(Dispatchers.IO) {
                registrationRepository.registration(email, password)
            }.let {
                it.addOnCompleteListener() { task ->
                    viewState.setResult(it.toString())
                }
                it.addOnFailureListener {
                    viewState.setResult(it.toString())
                }
            }
        }
    }

}
