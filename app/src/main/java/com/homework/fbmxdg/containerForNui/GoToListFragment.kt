package com.homework.fbmxdg.containerForNui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.homework.fbmxdg.R
import kotlinx.android.synthetic.main.go_to_list_fragment.*

class GoToListFragment : Fragment() {

    companion object {
        fun newInstance() = GoToListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.go_to_list_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_go_to_list.setOnClickListener {
            view.findNavController().navigate(R.id.action_goToListFragment_to_criminalsFragment)
        }
    }

}
