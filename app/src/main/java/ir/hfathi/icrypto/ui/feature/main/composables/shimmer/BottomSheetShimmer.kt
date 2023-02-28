package ir.hfathi.icrypto.ui.feature.main.composables.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.hfathi.icrypto.ui.theme.*
import ir.hfathi.icrypto.utils.ScreenSize

@Composable
fun BottomSheetShimmer(brush: Brush) {
    Column(
        modifier = Modifier
            .background(brush)
            .fillMaxWidth()
            .height((ScreenSize().height() * 0.80).dp)
            .padding(DP_20),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = DP_16)
                .requiredHeight(DP_40),
            contentAlignment = Alignment.Center,
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(LighterGray)
                        .size(DP_40)
                )

                Spacer(modifier = Modifier.width(DP_8))

                Box(
                    modifier = Modifier
                        .padding(top = DP_12)
                        .width(DP_80)
                        .height(DP_15)
                        .background(LighterGray)
                )
            }
        }

        Spacer(modifier = Modifier.height(DP_12))

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = DP_16)
        ) {
            Box(
                modifier = Modifier
                    .width(DP_80)
                    .height(DP_15)
                    .background(LighterGray)
            )

            Spacer(modifier = Modifier.height(DP_8))

            Row {
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

        Spacer(modifier = Modifier.height(DP_12))

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .weight(3f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(DP_200)
                    .background(LighterGray)
            )

            Spacer(modifier = Modifier.height(DP_8))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(DP_150)
                    .background(LighterGray)
            )
        }

        Row(horizontalArrangement = Arrangement.Center) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(LighterGray)
                    .weight(1f)
                    .height(DP_45)
            )

            Spacer(modifier = Modifier.width(DP_8))

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .weight(1f)
                    .height(DP_45)
                    .background(LighterGray)
            )
        }
    }
}

@Preview
@Composable
fun BottomSheetShimmer() {
    val brush = Brush.linearGradient(
        colors = ShimmerColorShades,
        start = Offset(10f, 10f),
        end = Offset(12f, 12f)
    )
    BottomSheetShimmer(brush = brush)
}