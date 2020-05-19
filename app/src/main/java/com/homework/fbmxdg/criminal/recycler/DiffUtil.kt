package com.homework.fbmxdg.criminalList.recycler

import androidx.recyclerview.widget.DiffUtil
import com.homework.fbmxdg.service.dataBase.models.Criminal

class DiffUtil(private val oldList: List<Criminal>, private val newList: List<Criminal>) :
    DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}
