package com.ryanphillips.tasky.core.designsystem.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ryanphillips.tasky.R

val Inter = FontFamily(
    Font(
        resId = R.font.inter_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.inter_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.inter_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.inter_semibold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resId = R.font.inter_thin,
        weight = FontWeight.Thin
    ),
    Font(
        resId = R.font.inter_light,
        weight = FontWeight.Light
    ),
    Font(
        resId = R.font.inter_extralight,
        weight = FontWeight.ExtraLight
    )
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.2).sp
    ),
    displayMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.2.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.2.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),

)

@Preview(showBackground = true)
@Composable
private fun InterFontPreview() {
    TaskyTheme {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Display Large",
                style = MaterialTheme.typography.displayLarge
            )
            Text(
                text = "Display Medium",
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = "Display Small",
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = "Headline Large",
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = "Headline Medium",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Headline Small",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "Title Large",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Title Medium",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Title Small",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "Body Large",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Body Medium",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Body Small",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Label Large",
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = "Label Medium",
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "Label Small",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}