package ir.hfathi.icrypto.ui.feature.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import ir.hfathi.icrypto.R
import ir.hfathi.icrypto.model.model.response.coin.Coin
import ir.hfathi.icrypto.model.model.response.coin.toCoins
import ir.hfathi.icrypto.ui.feature.home.HomeContract
import ir.hfathi.icrypto.ui.feature.home.HomeViewModel
import ir.hfathi.icrypto.ui.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun CoinListItem(
    coins: Coin,
    homeViewModel: HomeViewModel,
    onEventSent: (event: HomeContract.Event) -> Unit,
    openBottomSheet : () -> Unit
) {

    var price by remember { mutableStateOf("0") }

    LaunchedEffect(key1 = true) {
        CoroutineScope(Dispatchers.IO).launch {
            homeViewModel.coinStreamData.collect { responseData ->
                if (getSymbol(responseData.symbol) == coins.symbol) {
                    price = responseData.lastPrice
                }
            }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(DP_20)
            .clickable {
                onEventSent(
                    HomeContract.Event.CoinSelection(coin = coins.toCoins())
                )
                openBottomSheet.invoke()
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .weight(2f)
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(LighterGray)
                    .size(DP_50)
            ) {

                AsyncImage(
                    model = coins.icon,
                    contentDescription = stringResource(R.string.network_error_title),
                    modifier = Modifier
                        .size(DP_20)
                        .align(Alignment.Center)
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .weight(5f)
        ) {
            Text(
                text = coins.name,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                color = TextWhite,
                textAlign = TextAlign.Start
            )

            Row {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(DP_2))
                        .background(LighterGray)
                        .size(DP_16)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = coins.rank.toString(),
                        fontSize = SP_10,
                        fontWeight = FontWeight.Bold,
                        color = Gold,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
                Text(
                    text = coins.symbol,
                    fontSize = SP_12,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = DP_5)
                )

            }

        }

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .weight(3f)
        ) {
            Text(
                text = "$$price",
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
                color = TextWhite
            )

            Text(
                text = coins.priceChange1d.toString() + "%",
                fontSize = SP_12,
                fontWeight = FontWeight.Bold,
                color = if (coins.priceChange1d < 0) CustomRed else CustomGreen
            )
        }
    }

    Divider(color = LightGray)
}


private fun getSymbol(text: String): String =
    text.replace("tickers.", String()).replace("USDT", String())
