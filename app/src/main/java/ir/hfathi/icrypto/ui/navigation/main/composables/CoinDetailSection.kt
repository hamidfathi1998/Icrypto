package ir.hfathi.icrypto.ui.navigation.main.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.hfathi.icrypto.R
import ir.hfathi.icrypto.ui.theme.CustomGreen
import ir.hfathi.icrypto.ui.theme.CustomRed
import ir.hfathi.icrypto.ui.theme.LighterGray
import ir.hfathi.icrypto.ui.theme.TextWhite

@Composable
fun CoinDetailSection(
    price: Double,
    priceChange: Double
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                text = "$${price.toFloat()}",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6,
                color = TextWhite
            )

            Row(
                Modifier.padding(horizontal = 5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(3.dp))
                        .background(LighterGray)
                        .size(21.dp)
                ) {
                    Text(
                        text = "24h",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextWhite,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Text(
                    text = "$${priceChange.toFloat()}",
                    style = MaterialTheme.typography.body1,
                    color = if (priceChange < 0) CustomRed else CustomGreen
                )

                Image(
                    painter = if (priceChange < 0)
                        painterResource(id = R.drawable.ic_arrow_negative)
                    else
                        painterResource(id = R.drawable.ic_arrow_positive),
                    contentDescription = "arrow",
                    modifier = Modifier
                        .padding(4.dp)
                        .size(12.dp)
                )
            }

        }
    }
}