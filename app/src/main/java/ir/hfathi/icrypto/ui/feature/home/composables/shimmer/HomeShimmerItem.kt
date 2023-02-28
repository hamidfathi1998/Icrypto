package ir.hfathi.icrypto.ui.feature.home.composables.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import ir.hfathi.icrypto.ui.theme.*

@Composable
fun HomeShimmerItem(brush: Brush){
    Row(
        modifier = Modifier
            .background(brush)
            .fillMaxWidth()
            .padding(DP_20),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(LighterGray)
                .size(DP_50)
        )

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .weight(5f)
                .padding(start = DP_16)
        ) {
            Box(
                modifier = Modifier
                    .width(DP_80)
                    .height(DP_15)
                    .background(LighterGray)
            )

            Spacer(modifier = Modifier.height(DP_8))

            Row() {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(DP_2))
                        .background(LighterGray)
                        .size(DP_15)
                )

                Spacer(modifier = Modifier.width(DP_8))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(DP_2))
                        .background(LighterGray)
                        .width(DP_56)
                        .height(DP_15)
                )
            }

        }

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .weight(3f)
        ) {
            Box(
                modifier = Modifier
                    .width(DP_60)
                    .height(DP_15)
                    .background(LighterGray)
            )

            Spacer(modifier = Modifier.height(DP_8))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(DP_2))
                    .background(LighterGray)
                    .width(DP_30)
                    .height(DP_15)
            )
        }
    }

    Divider(color = LightGray)
}

@Preview
@Composable
fun HomeShimmerItemPreview(){
    val brush = Brush.linearGradient(
        colors = ShimmerColorShades,
        start = Offset(10f, 10f),
        end = Offset(12f, 12f)
    )
    HomeShimmerItem(brush = brush)
}