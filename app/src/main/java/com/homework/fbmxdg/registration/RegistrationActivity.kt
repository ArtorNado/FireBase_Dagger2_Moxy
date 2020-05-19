package com.homework.fbmxdg.registration

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.homework.fbmxdg.R
import com.homework.fbmxdg.app.App
import kotlinx.android.synthetic.main.activity_registration.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject
import javax.inject.Provider

class RegistrationActivity : MvpAppCompatActivity(), RegistrationView {

    @Inject
    lateinit var navigatioHolder: NavigatorHolder

    private val navigator: Navigator = SupportAppNavigator(this, -1)


    @Inject
    lateinit var presenterProvider: Provider<RegistrationPresenter>

    private val presenter: RegistrationPresenter by moxyPresenter {
        presenterProvider.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.provideRegistrationFeatureComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        initClickListeners()
    }

    private fun initClickListeners() {
        btn_registration.setOnClickListener {
            presenter.registration(et_email.text.toString(), et_password.text.toString())
        }
    }

    override fun setResult(text: String) {
        Snackbar.make(
            findViewById(android.R.id.content), text, Snackbar.LENGTH_INDEFINITE
        ).show()
    }

    override fun onResume() {
        super.onResume()
        navigatioHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatioHolder.removeNavigator()
        super.onPause()
    }
}
