package ir.hfathi.icrypto.model.repository

import ir.hfathi.icrypto.model.model.response.ChartResponseModel
import ir.hfathi.icrypto.model.model.response.CoinDetailResponseModel
import ir.hfathi.icrypto.model.model.response.CoinsResponseModel
import ir.hfathi.icrypto.model.model.response.CoinPriceResponseModel
import kotlinx.coroutines.flow.MutableStateFlow

interface CoinRepository {

    suspend fun getCoins(): Result<CoinsResponseModel>

    suspend fun getCoinById(coinId: String): Result<CoinDetailResponseModel>

    suspend fun getChartsData(coinId: String): Result<ChartResponseModel>

    fun getStreamCryptoPrice(data: MutableStateFlow<CoinPriceResponseModel>)
}