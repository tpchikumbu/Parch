package com.example.parch

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class HomeWidgetReceiver : GlanceAppWidgetReceiver () {
    override val glanceAppWidget: GlanceAppWidget
        get() = HomeWidget()

}