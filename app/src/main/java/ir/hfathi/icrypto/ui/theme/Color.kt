package ir.hfathi.icrypto.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LighterGray2 = Color(0xFF616161)
val LighterGray = Color(0xFF262532)
val TextWhite = Color(0xFFEEEEEE)
val DarkGray = Color(0xFF161520)
val LightGray = Color(0xFF1E1C25)
val CustomGreen = Color(0xFF19B661)
val CustomRed= Color(0xFFE8503A)
val Twitter = Color(0xFF00ACEE)
val Gold = Color(0xFFE6C149)

val ShimmerColorShades = listOf(
    LightGray.copy(1.0f),
    LightGray.copy(0.2f),
    LightGray.copy(1.0f)
)

@Composable
fun ShimmerAnimationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}