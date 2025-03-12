package com.example.parch

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.glance.GlanceId
import androidx.glance.GlanceTheme
import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.components.Scaffold
import androidx.glance.appwidget.components.TitleBar
import androidx.glance.appwidget.provideContent
import androidx.glance.text.Text
import androidx.glance.text.TextStyle

class HomeWidget: GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme{
                WidgetUI()
            }
        }
    }
}

@Composable
fun WidgetUI () {
    Scaffold(
        backgroundColor = GlanceTheme.colors.widgetBackground,
        titleBar = {
            TitleBar( startIcon = ImageProvider(R.mipmap.ic_launcher_round), title = "TO-DO")
        }
    ) {
        Text(
            text = "Hello World",
            style = TextStyle(color = GlanceTheme.colors.onSurface))
    }
}