package ir.hfathi.icrypto.ui.feature.main.composables

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.hfathi.icrypto.R
import ir.hfathi.icrypto.model.api.enumType.CoinPeriod
import ir.hfathi.icrypto.ui.theme.*

@Composable
fun CoinDetailSection(
    price: Double,
    priceChange: Double
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = DP_8),
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
                Modifier.padding(horizontal = DP_5)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(DP_3))
                        .background(LighterGray)
                        .size(20.dp)
                ) {
                    Text(
                        text = CoinPeriod.PERIOD_24H.period,
                        fontSize = SP_10,
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
                    contentDescription = stringResource(id = R.string.arrow),
                    modifier = Modifier
                        .padding(DP_4)
                        .size(DP_12)
                )
            }

        }
    }
}