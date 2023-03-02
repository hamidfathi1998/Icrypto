package ir.hfathi.icrypto.model.repository

import ir.hfathi.icrypto.model.model.response.chart.ChartResponseModel
import ir.hfathi.icrypto.model.model.response.coin.CoinDetailResponseModel
import ir.hfathi.icrypto.model.model.response.coin.CoinsResponseModel
import ir.hfathi.icrypto.model.model.response.coin.CoinPriceResponseModel
import ir.hfathi.icrypto.model.model.response.news.NewsResponseModel
import kotlinx.coroutines.flow.MutableStateFlow

interface CoinRepository {

    suspend fun getCoins(): Result<CoinsResponseModel>

    suspend fun getCoinById(coinId: String): Result<CoinDetailResponseModel>

    suspend fun getChartsData(coinId: String): Result<ChartResponseModel>

    suspend fun getNewsData(): Result<NewsResponseModel>

    fun getStreamCryptoPrice(data: MutableStateFlow<CoinPriceResponseModel>)
}