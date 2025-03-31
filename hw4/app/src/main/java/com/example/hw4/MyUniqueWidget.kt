
package com.example.hw4

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.layout.*
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import java.util.*

class MyUniqueWidget : GlanceAppWidget() {

    @Composable
    override fun Content() {
        GlanceTheme {
            Column(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .background(Color(0xFF1E1E1E))
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Текущее время
                Text(
                    text = getCurrentTime(),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = GlanceModifier.height(8.dp))

                // Заряд батареи
                BatteryStatus()

                Spacer(modifier = GlanceModifier.height(8.dp))

                // Мотивационная цитата
                Text(
                    text = getRandomQuote(),
                    style = TextStyle(
                        color = Color(0xFFBB86FC),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }

    private fun getCurrentTime(): String {
        return Calendar.getInstance().time.toString().split(" ")[3]
    }

    private fun getRandomQuote(): String {
        val quotes = listOf(
            "Действуй!",
            "Никогда не сдавайся!",
            "Мечты сбываются!",
            "Ты можешь всё!",
            "Начни с малого!"
        )
        return quotes.random()
    }

    @Composable
    private fun BatteryStatus() {
        // Здесь можно добавить логику для получения уровня заряда батареи
        val batteryLevel = "85%"
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                provider = ImageProvider(R.drawable.ic_battery), // Иконка батареи
                contentDescription = "Battery",
                modifier = GlanceModifier.size(24.dp)
            )
            Spacer(modifier = GlanceModifier.width(8.dp))
            Text(
                text = batteryLevel,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 18.sp
                )
            )
        }
    }
}