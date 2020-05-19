package com.homework.fbmxdg.criminalList.recycler

import androidx.recyclerview.widget.DiffUtil
import com.homework.fbmxdg.service.dataBase.models.Criminal

object Diff : DiffUtil.ItemCallback<Criminal>() {

    override fun areItemsTheSame(oldItem: Criminal, newItem: Criminal): Boolean =
        oldItem.firstName == newItem.firstName

    override fun areContentsTheSame(oldItem: Criminal, newItem: Criminal): Boolean =
        oldItem.secondName == newItem.secondName

}
