package com.ryanphillips.tasky.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = Black,
    secondary = Green1,
    tertiary = Lime,
    background = Black,
    onBackground = White,
    surface = White,
    onSurface = Grey1,
    onSurfaceVariant = Grey3,
    error = Red1,
    outline = GreyBlue
)

private val DarkColorScheme = darkColorScheme(
    primary = White,
    secondary = Green1,
    tertiary = Lime,
    background = Black,
    onBackground = White,
    surface = Black2,
    onSurface = OffWhite,
    onSurfaceVariant = Grey4,
    error = Red2,
    outline = Grey2,
)

@Composable
fun TaskyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}