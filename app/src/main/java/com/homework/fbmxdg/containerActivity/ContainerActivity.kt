package com.homework.fbmxdg.containerActivity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import moxy.ktx.moxyPresenter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.homework.fbmxdg.R
import com.homework.fbmxdg.app.App
import kotlinx.android.synthetic.main.activity_container.*
import moxy.MvpAppCompatActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider

class ContainerActivity : MvpAppCompatActivity(), ContainerView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator = SupportAppNavigator(this, R.id.nav_host_fragment)

    @Inject
    lateinit var remoteConfig: FirebaseRemoteConfig

    @Inject
    lateinit var presenterProvider: Provider<ContainerPresenter>

    private val presenter: ContainerPresenter by moxyPresenter {
        presenterProvider.get()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.provideContainerFeatureComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
        setSupportActionBar(toolbar_actionbar)
        presenter.initStartFragment()
        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        remoteConfig()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            R.id.action_add -> {
                presenter.addOptionItemClick()
                true
            }
            R.id.action_crash -> {
                throw IllegalArgumentException()
            }
            R.id.next_container -> {
                presenter.goNextContainerClick()
                return true
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
        if (remoteConfig.getBoolean("fab_active")) toolbar_actionbar.visibility =
            View.VISIBLE
        else toolbar_actionbar.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    companion object {
        private const val ARG_TIME: Long = 3600
    }

}
