package ir.hfathi.icrypto.model.repository

import ir.hfathi.icrypto.model.model.dto.ChartDto
import ir.hfathi.icrypto.model.model.dto.CoinDetailDto
import ir.hfathi.icrypto.model.model.dto.CoinsDto
import ir.hfathi.icrypto.model.model.response.CoinPriceResponseModel
import kotlinx.coroutines.flow.MutableStateFlow

interface CoinRepository {

    suspend fun getCoins(): Result<CoinsDto>

    suspend fun getCoinById(coinId: String): Result<CoinDetailDto>

    suspend fun getChartsData(coinId: String): Result<ChartDto>

    fun getStreamCryptoPrice(data: MutableStateFlow<CoinPriceResponseModel>)
}