package com.example.tjohnn.plotdemo

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.androidplot.xy.BarFormatter
import com.androidplot.xy.BoundaryMode
import com.androidplot.xy.SimpleXYSeries
import com.androidplot.xy.StepMode
import com.androidplot.xy.XYPlot

class DemoGraphView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(
    context,
    attrs,
    defStyleAttr
) {

    private val plotView get() = findViewById<XYPlot>(R.id.plot)

    init {
        layoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        inflate(context, R.layout.demo_graph_view, this)
        plotView.setDomainBoundaries(0, 10, BoundaryMode.FIXED)
        plotView.setDomainStep(StepMode.INCREMENT_BY_VAL, 1.0)
        plotView.setRangeBoundaries(0, 3, BoundaryMode.FIXED)
        plotView.setRangeStep(StepMode.INCREMENT_BY_VAL, 1.0)
    }

    fun drawSeries() {
        plotView.clear()
        plotView.addSeries(
            SimpleXYSeries("Title").apply {
                addLast(0, 3)
                addLast(1, 1)
                addLast(2, 1)
                addLast(3, 2.1)
                addLast(4, 2.2)
                addLast(5, .8)
                addLast(6, 1.1)
                addLast(7, 2.7)
                addLast(8, 0.9)
                addLast(9, 1.6)
            },
            BarFormatter(Color.GREEN, Color.GRAY)
        )
        plotView.redraw()
    }
}
