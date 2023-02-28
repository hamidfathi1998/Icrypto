package ir.hfathi.icrypto.ui.feature.main.composables.shimmer

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import ir.hfathi.icrypto.ui.theme.ShimmerAnimDurationMillis
import ir.hfathi.icrypto.ui.theme.ShimmerColorShades

@Composable
fun BottomSheetShimmerAnimation() {
    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = ShimmerAnimDurationMillis, easing = FastOutSlowInEasing),
            RepeatMode.Reverse
        )
    )
    val brush = Brush.linearGradient(
        colors = ShimmerColorShades,
        start = Offset(10f, 10f),
        end = Offset(translateAnim, translateAnim)
    )
    BottomSheetShimmer(brush = brush)
}