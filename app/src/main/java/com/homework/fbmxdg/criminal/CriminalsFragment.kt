package com.homework.fbmxdg.criminalList

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.homework.fbmxdg.R
import com.homework.fbmxdg.app.App
import com.homework.fbmxdg.criminalList.recycler.CriminalsAdapter
import com.homework.fbmxdg.service.dataBase.models.Criminal
import kotlinx.android.synthetic.main.criminals_fragment.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class CriminalsFragment : MvpAppCompatFragment(), CriminalsView {

    @Inject
    lateinit var presenterProvider: Provider<CriminalsPresenter>

    private val presenter: CriminalsPresenter by moxyPresenter {
        presenterProvider.get()
    }

    private var adapter: CriminalsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.criminals_fragment, container, false)

    override fun onAttach(context: Context) {
        App.appComponent.provideCriminalsFeatureComponent().inject(this)
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
        Log.e("RESUME", "RESUME")
        presenter.getData("Criminals")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("VIEW_CREATED", "VIEW_CREATED")
        presenter.getData("Criminals")
    }

    override fun setAdapter(list: List<Criminal>) {
        rv_criminals_list.layoutManager = LinearLayoutManager(context)
        adapter = CriminalsAdapter(list) {

        }
        rv_criminals_list.adapter = adapter
    }


}
