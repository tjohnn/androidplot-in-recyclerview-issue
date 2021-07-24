package com.example.tjohnn.plotdemo

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PlotsAdapter : RecyclerView.Adapter<PlotsAdapter.PlotViewHolder>() {
    var items: List<Int> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlotViewHolder {
        val binding = DemoGraphView(parent.context)
        return PlotViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PlotViewHolder, position: Int) {
        holder.bindData()
    }

    inner class PlotViewHolder(
        private val view: DemoGraphView
    ) : RecyclerView.ViewHolder(view) {

        fun bindData() {
            view.drawSeries()
        }
    }
}
