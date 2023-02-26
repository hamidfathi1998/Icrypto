package ir.hfathi.icrypto.model.repository

import ir.hfathi.icrypto.model.model.CoinChartModel
import ir.hfathi.icrypto.model.model.CoinDetailModel
import ir.hfathi.icrypto.model.model.CoinModel

interface CoinRepository {

    suspend fun getAllCryptoCurrency() : Result<List<CoinModel>>

    suspend fun getSpecificCryptoDetails(coinId: String) : Result<CoinDetailModel>

    suspend fun getCryptoChartData(coinId: String) : Result<CoinChartModel>
}