package ir.hfathi.icrypto.ui.feature.news.composables.shimmer

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.hfathi.icrypto.ui.theme.DP_20
import ir.hfathi.icrypto.ui.theme.ShimmerAnimRepeatCount
import ir.hfathi.icrypto.ui.theme.ShimmerAnimationTheme


@Composable
fun NewsShimmerContent() {
    ShimmerAnimationTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colors.background, modifier = Modifier.padding(top = DP_20)) {
            LazyColumn {
                repeat(ShimmerAnimRepeatCount) {
                    item {
                        NewsShimmerAnimation()
                    }
                }
            }
        }
    }
}
