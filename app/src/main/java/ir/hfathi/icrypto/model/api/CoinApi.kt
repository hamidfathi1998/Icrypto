package ir.hfathi.icrypto.model.api

import ir.hfathi.icrypto.model.api.CoinPeriod.PERIOD_24h
import ir.hfathi.icrypto.model.api.Endpoints.GET_ALL_CRYPTO_CURRENCY
import ir.hfathi.icrypto.model.api.Endpoints.GET_CRYPTO_CHART_DATA
import ir.hfathi.icrypto.model.api.Endpoints.GET_SPECIFIC_CRYPTO_DETAILS
import ir.hfathi.icrypto.model.model.CoinChartModel
import ir.hfathi.icrypto.model.model.CoinDetailModel
import ir.hfathi.icrypto.model.model.CoinModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApi {

    @GET(GET_ALL_CRYPTO_CURRENCY)
    suspend fun getAllCryptoCurrency(
        @Query("currency") currency: String = CoinCurrency.CURRENCY_USD,
        @Query("skip") skip: Int = 0
    ): List<CoinModel>

    @GET(GET_SPECIFIC_CRYPTO_DETAILS)
    suspend fun getSpecificCryptoDetails(
        @Path("coinId") coinId: String
    ): CoinDetailModel

    @GET(GET_CRYPTO_CHART_DATA)
    suspend fun getCryptoChartData(
        @Query("coinId") coinId: String,
        @Query("period") period: String = PERIOD_24h
    ): CoinChartModel

}