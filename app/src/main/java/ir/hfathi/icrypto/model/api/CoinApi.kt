package ir.hfathi.icrypto.model.api

import ir.hfathi.icrypto.model.model.dto.ChartDto
import ir.hfathi.icrypto.model.model.dto.CoinDetailDto
import ir.hfathi.icrypto.model.model.dto.CoinsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApi {

    @GET("v1/coins")
    suspend fun getCoins(
        @Query("currency") currency: String = "USD",
        @Query("skip") skip: Int = 0
    ): CoinsDto

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailDto

    @GET("v1/charts")
    suspend fun getChartsData(
        @Query("coinId") coinId: String,
        @Query("period") period: String = "24h" //available periods - 24h | 1w | 1m | 3m | 6m | 1y | all
    ): ChartDto


}