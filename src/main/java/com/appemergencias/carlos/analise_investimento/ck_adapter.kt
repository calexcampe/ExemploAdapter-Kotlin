package com.appemergencias.carlos.analise_investimento

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.appemergencias.carlos.analise_investimento.List_adapter
import com.appemergencias.carlos.analise_investimento.R

import kotlinx.android.synthetic.main.adapter.view.*

class ck_adapter (var partItemList: List<List_adapter>, val clickListener: (List_adapter) -> Unit) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // LayoutInflater: takes ID from layout defined in XML.
        // Instantiates the layout XML into corresponding View objects.
        // Use context from main app -> also supplies theme layout values!
        val inflater = LayoutInflater.from(parent.context)
        // Inflate XML. Last parameter: don't immediately attach new view to the parent view group
        val view = inflater.inflate(R.layout.adapter, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Populate ViewHolder with data that corresponds to the position in the list
        // which we are told to load
        (holder as PartViewHolder).bind(partItemList[position], clickListener)
    }

    override fun getItemCount() = partItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: List_adapter, clickListener: (List_adapter) -> Unit) {

            itemView.note_item_title.text = part.title
            itemView.note_item_description.text = part.description
            itemView.txtv_amount.text = part.amount
            itemView.txt_roi.text = part.roi
            itemView.setOnClickListener { clickListener(part)}
        }
    }

}
