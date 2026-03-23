package com.example.weatherapp20.ui.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Blue40,
    secondary = Blue80,
    background = SurfaceLight,
    surface = CardLight,
    onBackground = Night,
    onSurface = Night
)

private val DarkColors = darkColorScheme(
    primary = Blue80,
    background = Night,
    surface = Night,
    onBackground = CardLight,
    onSurface = CardLight
)

@Composable
fun WeatherTrackerTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography(),
        content = content
    )
}
