package ir.hfathi.icrypto.ui.feature.news.composables.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import ir.hfathi.icrypto.ui.theme.*


@Composable
fun NewsShimmerItem(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(DP_200)
            .padding(start = DP_16, end = DP_16, bottom = DP_16)
            .background(brush)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(DP_15),
            elevation = DP_5,
            backgroundColor = LighterGray2
        ) {}
    }
}
