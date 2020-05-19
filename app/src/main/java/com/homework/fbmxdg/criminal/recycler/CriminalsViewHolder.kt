package com.homework.fbmxdg.criminalList.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homework.fbmxdg.R
import com.homework.fbmxdg.service.dataBase.models.Criminal
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.criminal_template.view.*

class CriminalsViewHolder(
    override val containerView: View,
    private val clickLambda: (Criminal) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(criminal: Criminal) {
        containerView.tv_firstName.text = criminal.firstName
        containerView.tv_secondName.text = criminal.secondName
        containerView.tv_country.text = criminal.country
    }

    companion object {
        fun create(parent: ViewGroup, clickLambda: (Criminal) -> Unit) =
            CriminalsViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.criminal_template,
                    parent,
                    false
                ),
                clickLambda
            )
    }
}
