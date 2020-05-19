package com.homework.fbmxdg.service.google

import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.lang.IllegalArgumentException
import javax.inject.Inject

class GoogleServiceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : GoogleService {


    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount): Task<AuthResult> {
        Log.d("TAG", "firebaseAuthWithGoogle:" + acct.id!!)
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        return auth.signInWithCredential(credential)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        rcSign: Int
    ): Task<AuthResult> {
        if (requestCode == rcSign) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                return firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("TAG", "Google sign in failed", e)
                // [START_EXCLUDE]
                Log.e("UPDATE_UI", "HER_NA")
                // [END_EXCLUDE]
            }
        }
        throw IllegalArgumentException("Failed")
    }
}
