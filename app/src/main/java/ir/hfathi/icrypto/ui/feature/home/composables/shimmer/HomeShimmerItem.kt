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
import androidx.compose.ui.unit.dp
import ir.hfathi.icrypto.ui.theme.*

@Composable
fun HomeShimmerItem(brush: Brush){
    Row(
        modifier = Modifier
            .background(brush)
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(LighterGray)
                .size(50.dp)
        )

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .weight(5f)
                .padding(start = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(15.dp)
                    .background(LighterGray)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row() {
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

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .weight(3f)
        ) {
            Box(
                modifier = Modifier
                    .width(60.dp)
                    .height(15.dp)
                    .background(LighterGray)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .background(LighterGray)
                    .width(30.dp)
                    .height(15.dp)
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