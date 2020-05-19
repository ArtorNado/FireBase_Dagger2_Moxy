package com.homework.fbmxdg.criminalList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.homework.fbmxdg.R
import com.homework.fbmxdg.app.App
import com.homework.fbmxdg.criminalList.repository.CreateCriminalPresenter
import com.homework.fbmxdg.service.dataBase.models.Criminal
import kotlinx.android.synthetic.main.create_criminal_fragment.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class CreateCriminalFragment : MvpAppCompatFragment(), CriminalsCreateView {

    @Inject
    lateinit var presenterProvider: Provider<CreateCriminalPresenter>

    private val presenter: CreateCriminalPresenter by moxyPresenter {
        presenterProvider.get()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.create_criminal_fragment, container, false)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.appComponent.provideCriminalsFeatureComponent().injectCreateCriminal(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
    }

    private fun initClickListeners() {
        btn_create.setOnClickListener {
            presenter.addCriminal(
                Criminal(
                    et_firstName.text.toString(),
                    et_secondName.text.toString(),
                    et_country.text.toString()
                ), "Criminals"
            )
        }
    }

    override fun navigateBack() {
        NavHostFragment.findNavController(this).popBackStack()
    }


}
