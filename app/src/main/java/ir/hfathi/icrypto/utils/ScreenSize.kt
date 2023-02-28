package ir.hfathi.icrypto.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

class ScreenSize {
    @Composable
    fun height(): Int {
        val configuration = LocalConfiguration.current
        return configuration.screenHeightDp
    }
}