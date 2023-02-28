package ir.hfathi.icrypto.ui.feature.main.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import ir.hfathi.icrypto.model.model.dto.ChartDto
import ir.hfathi.icrypto.model.model.dto.CoinDetailDto
import ir.hfathi.icrypto.ui.feature.home.HomeViewModel
import ir.hfathi.icrypto.ui.feature.main.composables.shimmer.BottomSheetShimmerContent
import org.koin.androidx.compose.getViewModel
import ir.hfathi.icrypto.ui.theme.*
import ir.hfathi.icrypto.utils.ScreenSize
import java.text.NumberFormat
import java.util.*

@Composable
fun CoinDetailsBottomSheetContent() {
    val homeViewModel = getViewModel<HomeViewModel>()
    val state = homeViewModel.viewState.value
    val chartData = state.coinChartData
    val coinDetailsData = state.coinDetailsData
    when {
        state.isLoading || state.isCoinDetailLoading -> BottomSheetShimmerContent()
        else -> CoinDetailsBottomSheetBody(
            chartData = chartData,
            coinDetailsData = coinDetailsData
        )
    }
}

@Composable
fun CoinDetailsBottomSheetBody(chartData: ChartDto?, coinDetailsData: CoinDetailDto?) {
    Box(
        modifier = Modifier
            .background(DarkGray)
            .fillMaxWidth()
            .height((ScreenSize().height() * 0.75).dp)
            .padding(12.dp)
    ) {
        coinDetailsData?.coin?.let { coin ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    TopBarCoinDetail(
                        coinSymbol = coin.symbol,
                        icon = coin.icon,
                    )
                    CoinDetailSection(
                        price = coin.price,
                        priceChange = coin.priceChange1d
                    )
                    Chart(
                        oneDayChange = coin.priceChange1d,
                        context = LocalContext.current,
                        coinChartData = chartData
                    )
                    CoinInformation(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = LighterGray,
                                shape = RoundedCornerShape(25.dp)
                            )
                            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                        rank = "${coin.rank}",
                        volume = numbersToCurrency(coin.volume.toInt())!!,
                        marketCap = numbersToCurrency(coin.marketCap.toInt())!!,
                        availableSupply = "${numbersToFormat(coin.availableSupply.toInt())} ${coin.symbol}",
                        totalSupply = "${numbersToFormat(coin.totalSupply.toInt())} ${coin.symbol}"
                    )

                    val uriHandler = LocalUriHandler.current
                    Row(
                        horizontalArrangement = Arrangement.Center
                    ) {
                        LinkButton(
                            title = "Twitter",
                            modifier = Modifier
                                .padding(start = 20.dp, bottom = 20.dp, top = 20.dp)
                                .clip(RoundedCornerShape(35.dp))
                                .height(45.dp)
                                .background(Twitter)
                                .weight(1f)
                                .clickable {
                                    uriHandler.openUri(coin.twitterUrl)
                                }
                        )

                        LinkButton(
                            title = "Website",
                            modifier = Modifier
                                .padding(start = 20.dp, bottom = 20.dp, top = 20.dp)
                                .clip(RoundedCornerShape(35.dp))
                                .height(45.dp)
                                .background(LighterGray)
                                .weight(1f)
                                .clickable {
                                    uriHandler.openUri(coin.websiteUrl)
                                }
                        )
                    }
                }
            }
        }
    }
}

fun numbersToCurrency(number: Int): String? {
    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.currency = Currency.getInstance("USD")
    return numberFormat.format(number)
}

fun numbersToFormat(number: Int): String? {
    val numberFormat = NumberFormat.getNumberInstance()
    return numberFormat.format(number)
}