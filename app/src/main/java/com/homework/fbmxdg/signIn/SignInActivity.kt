package com.homework.fbmxdg.signIn

import android.content.Intent
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.homework.fbmxdg.containerActivity.ContainerActivity
import com.homework.fbmxdg.R
import com.homework.fbmxdg.app.App
import com.homework.fbmxdg.passwordLess.PasswordLessActivity
import com.homework.fbmxdg.registration.RegistrationActivity
import kotlinx.android.synthetic.main.activity_signin.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class SignInActivity : MvpAppCompatActivity(), SignInView {

    @Inject
    lateinit var presenterProvider: Provider<SignInPresenter>

    private val presenter: SignInPresenter by moxyPresenter {
        presenterProvider.get()
    }
    private lateinit var googleSignInClient: GoogleSignInClient

    val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.provideSignInFeatureComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        val storage = Firebase.storage
        val storageRef = storage.reference
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

    override fun signIn() {}

    override fun openGoogleActivity() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun signInWithPhoneNumber() {}

    override fun goToRegisr() {}

    override fun navigateToProfile() {}

    override fun navigateToRegistrPage() {
        Intent(this, RegistrationActivity::class.java).also {
            startActivity(it)
        }
    }

    override fun navigateToResetPage() {
        Intent(this, PasswordLessActivity::class.java).also {
            startActivity(it)
        }
    }

    override fun navigateToList() {
        Intent(this, ContainerActivity::class.java).also {
            startActivity(it)
        }
    }


    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }

}
