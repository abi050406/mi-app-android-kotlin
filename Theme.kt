package com.miapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF00796B),
    onPrimary = Color.White,
    secondary = Color(0xFF004D40),
    background = Color(0xFFF5F7F8),
    surface = Color.White,
    onSurface = Color(0xFF212121),
    onSurfaceVariant = Color(0xFF546E7A)
)

@Composable
fun MiAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}
