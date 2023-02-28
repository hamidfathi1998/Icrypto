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
            .height((ScreenSize().height() * 0.75).dp)
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .requiredHeight(40.dp),
            contentAlignment = Alignment.Center,
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(LighterGray)
                        .size(40.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .width(80.dp)
                        .height(15.dp)
                        .background(LighterGray)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(15.dp)
                    .background(LighterGray)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .background(LighterGray)
                        .size(15.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .background(LighterGray)
                        .width(56.dp)
                        .height(15.dp)
                )
            }

        }

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .weight(3f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(LighterGray)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(LighterGray)
            )
        }

        Row(horizontalArrangement = Arrangement.Center) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(LighterGray)
                    .weight(1f)
                    .height(45.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .weight(1f)
                    .height(45.dp)
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