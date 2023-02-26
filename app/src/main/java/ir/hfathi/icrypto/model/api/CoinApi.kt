package ir.hfathi.icrypto.model.api

import ir.hfathi.icrypto.model.api.CoinPeriod.PERIOD_24h
import ir.hfathi.icrypto.model.model.CoinDetailModel
import ir.hfathi.icrypto.model.model.CoinModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApi {

    @GET("v1/coins")
    suspend fun getCoins(
        @Query("currency") currency: String = CoinCurrency.CURRENCY_USD,
        @Query("skip") skip: Int = 0
    ): List<CoinModel>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailModel

    @GET("v1/charts")
    suspend fun getChartsData(
        @Query("coinId") coinId: String,
        @Query("period") period: String = PERIOD_24h
    ): List<CoinModel>

}