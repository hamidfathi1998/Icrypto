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
import ir.hfathi.icrypto.model.api.enumType.CoinCurrency
import ir.hfathi.icrypto.model.model.response.chart.ChartResponseModel
import ir.hfathi.icrypto.model.model.response.coin.CoinDetailResponseModel
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
fun CoinDetailsBottomSheetBody(chartData: ChartResponseModel?, coinDetailsData: CoinDetailResponseModel?) {
    Box(
        modifier = Modifier
            .background(DarkGray)
            .fillMaxWidth()
            .height((ScreenSize().height() * 0.80).dp)
            .padding(DP_12)
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
                                shape = RoundedCornerShape(DP_25)
                            )
                            .padding(start = DP_16, top = DP_16, end = DP_16),
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
                                .padding(start = DP_20, bottom = DP_20, top = DP_20)
                                .clip(RoundedCornerShape(35.dp))
                                .height(DP_45)
                                .background(Twitter)
                                .weight(1f)
                                .clickable {
                                    uriHandler.openUri(coin.twitterUrl)
                                }
                        )

                        LinkButton(
                            title = "Website",
                            modifier = Modifier
                                .padding(start = DP_20, bottom = DP_20, top = DP_20)
                                .clip(RoundedCornerShape(DP_35))
                                .height(DP_45)
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
    numberFormat.currency = Currency.getInstance(CoinCurrency.CURRENCY_USD.currency)
    return numberFormat.format(number)
}

fun numbersToFormat(number: Int): String? {
    val numberFormat = NumberFormat.getNumberInstance()
    return numberFormat.format(number)
}