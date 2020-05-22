package com.homework.fbmxdg.signIn

import android.content.Intent
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.snackbar.Snackbar
import com.homework.fbmxdg.R
import com.homework.fbmxdg.app.App
import kotlinx.android.synthetic.main.activity_signin.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject
import javax.inject.Provider

class SignInActivity : MvpAppCompatActivity(), SignInView {

    @Inject
    lateinit var navigatioHolder: NavigatorHolder

    private val navigator: Navigator = SupportAppNavigator(this, -1)

    @Inject
    lateinit var presenterProvider: Provider<SignInPresenter>

    private val presenter: SignInPresenter by moxyPresenter {
        presenterProvider.get()
    }
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.provideSignInFeatureComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        initClickListeners()
    }

    private fun initClickListeners(){
        btn_logIn.setOnClickListener {
            presenter.onLogInClick(et_login.text.toString(), et_password.text.toString()) //"epik@mail.ru", "123456"
        }
        btn_logIn_google.setOnClickListener {
            presenter.signInWithGoogle()
        }
        btn_send_verif_code.setOnClickListener {
            presenter.startPhoneNumberVerification(et_login.text.toString()) //"+79270415982"
        }
        btn_login_phone.setOnClickListener {
            presenter.verifyPhoneNumberWithCode(et_password.text.toString()) // "223567"
        }
        btn_go_to_register.setOnClickListener {
            presenter.registrButtonClick()
        }
        btn_go_to_reset.setOnClickListener {
            presenter.resetButtonClick()
        }
    }

    override fun setResult(text: String) {
        Snackbar.make(
            findViewById(android.R.id.content), text, Snackbar.LENGTH_INDEFINITE
        ).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data, RC_SIGN_IN)
    }


    override fun openGoogleActivity() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onResume() {
        super.onResume()
        navigatioHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatioHolder.removeNavigator()
        super.onPause()
    }


    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }

}
