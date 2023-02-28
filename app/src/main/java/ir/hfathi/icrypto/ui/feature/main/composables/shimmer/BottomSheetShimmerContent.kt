package ir.hfathi.icrypto.ui.feature.main.composables.shimmer

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import ir.hfathi.icrypto.ui.theme.ShimmerAnimationTheme

@Composable
fun BottomSheetShimmerContent(){
    ShimmerAnimationTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colors.background) {
            BottomSheetShimmerAnimation()
        }
    }
}