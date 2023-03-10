package ir.hfathi.icrypto.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

val DarkColorPalette = darkColors(
    primary = CustomGreen,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = LightGray
)

val LightColorPalette = lightColors(
    primary = CustomGreen,
    background = DarkGray,
    onBackground = TextWhite,
    onPrimary = LightGray

)

@Composable
fun IcryptoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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