package com.homework.fbmxdg.screen

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.homework.fbmxdg.containerActivity.ContainerActivity
import com.homework.fbmxdg.criminalList.CreateCriminalFragment
import com.homework.fbmxdg.criminalList.CriminalsFragment
import com.homework.fbmxdg.passwordLess.PasswordLessActivity
import com.homework.fbmxdg.registration.RegistrationActivity
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object CriminalsScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = CriminalsFragment()
    }

    object CreateCriminalsScreen : SupportAppScreen() {
        override fun getFragment(): Fragment = CreateCriminalFragment()
    }

    object RegistrationScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context): Intent =
            Intent(context, RegistrationActivity::class.java)
    }

    object ContainerScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context): Intent =
            Intent(context, ContainerActivity::class.java)
    }

    object PasswordLessScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context): Intent =
            Intent(context, PasswordLessActivity::class.java)
    }

}

