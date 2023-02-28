package ir.hfathi.icrypto.ui.feature.home.composables.shimmer

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import ir.hfathi.icrypto.ui.theme.ShimmerAnimationTheme

@Composable
fun HomeShimmerContent(){
    ShimmerAnimationTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colors.background) {
            LazyColumn {
                repeat(10) {
                    item {
                        HomeShimmerAnimation()
                    }
                }
            }
        }
    }
}