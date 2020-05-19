package com.homework.fbmxdg.criminalList.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.homework.fbmxdg.service.dataBase.models.Criminal

class CriminalsAdapter(
    private var criminals: List<Criminal>,
    private var clickLambda: (Criminal) -> Unit
) : ListAdapter<Criminal, CriminalsViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CriminalsViewHolder =
        CriminalsViewHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = criminals.size

    override fun onBindViewHolder(holder: CriminalsViewHolder, position: Int) {
        holder.bind(criminals[position])
    }
    
    override fun submitList(list: MutableList<Criminal>?) {
        super.submitList(list)
    }

    fun updateList(newList: List<Criminal>) {
        androidx.recyclerview.widget.DiffUtil.calculateDiff(DiffUtil(this.criminals, newList), false)
            .dispatchUpdatesTo(this)
        this.criminals = newList
    }
}
