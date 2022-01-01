package com.androiddevs.runningappyt.other

import android.content.Context
import com.androiddevs.runningappyt.db.Run
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.marker_view.view.*
import java.text.SimpleDateFormat
import java.util.*

class CustomMarkerView(
    val runs : List<Run>,
    c:Context,
    layoutId:Int
) :MarkerView(c,layoutId){

    override fun getOffset(): MPPointF {
        return MPPointF(-width / 2f , -height.toFloat())
    }

    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        super.refreshContent(e, highlight)
        if(e==null)
            return
        val currRunId = e.x.toInt()
        val run = runs[currRunId]

        val calendar = Calendar.getInstance().apply {
            timeInMillis=run.timestamp
        }
        val dateformat = SimpleDateFormat("dd/MM/yy", Locale.getDefault())
        tvDate.text=dateformat.format(calendar.time)

        val avgspeed ="${run.avgSpeedInKMH}km/h"
        tvAvgSpeed.text=avgspeed

        val distance ="${run.distanceInMetres / 1000f}km"

        tvDistance.text=distance

        tvDuration.text = TrackingUtility.getFormattedStopWatchTime(run.timeInMillis)

        val caloriesBurned = "${run.caloriesBurned}kcal"
        tvCaloriesBurned.text = caloriesBurned
    }
}