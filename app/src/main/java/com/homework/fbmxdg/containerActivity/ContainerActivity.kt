package com.homework.fbmxdg.containerActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.homework.fbmxdg.R
import com.homework.fbmxdg.app.App
import kotlinx.android.synthetic.main.activity_container.*
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ContainerActivity : AppCompatActivity() {

    @Inject
    lateinit var remoteConfig: FirebaseRemoteConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.provideContainerFeatureComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        setSupportActionBar(toolbar_actionbar)
        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        remoteConfig()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            R.id.action_add -> {
                val navController = findNavController(R.id.nav_host_fragment)
                navController.navigate(R.id.action_criminalsFragment_to_navigation_createCriminal)
                true
            }
            R.id.action_crash -> {
                throw IllegalArgumentException()
            }
            else -> true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.tb_menu, menu)
        return true
    }

    private fun remoteConfig() {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = ARG_TIME
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        fetchAndActivate()
    }

    private fun fetchAndActivate() {
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val updated = task.result
                    Log.e("TASK", "Config params updated: $updated")
                } else {
                    Toast.makeText(
                        this, "Fetch failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                actionBarIsActive()
            }
    }

    private fun actionBarIsActive() {
        Log.e("TASK2", remoteConfig.getBoolean("fab_active").toString())
        if (remoteConfig.getBoolean("fab_active")) toolbar_actionbar.visibility =
            View.VISIBLE
        else toolbar_actionbar.visibility = View.GONE
    }

    companion object{
        private const val ARG_TIME: Long = 3600
    }

}
