package ir.hfathi.icrypto.model.api

import ir.hfathi.icrypto.model.api.Endpoints.GET_CHART_DATA
import ir.hfathi.icrypto.model.api.Endpoints.GET_COINS_ENDPOINTS
import ir.hfathi.icrypto.model.api.Endpoints.GET_SPECIAL_COIN
import ir.hfathi.icrypto.model.api.enumType.CoinCurrency
import ir.hfathi.icrypto.model.api.enumType.CoinPeriod
import ir.hfathi.icrypto.model.model.response.chart.ChartResponseModel
import ir.hfathi.icrypto.model.model.response.coin.CoinDetailResponseModel
import ir.hfathi.icrypto.model.model.response.coin.CoinsResponseModel
import ir.hfathi.icrypto.model.model.response.news.NewsResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApi {

    @GET(GET_COINS_ENDPOINTS)
    suspend fun getCoins(
        @Query("currency") currency: String = CoinCurrency.CURRENCY_USD.currency,
        @Query("skip") skip: Int = 0
    ): CoinsResponseModel

    @GET(GET_SPECIAL_COIN)
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailResponseModel

    @GET(GET_CHART_DATA)
    suspend fun getChartsData(
        @Query("coinId") coinId: String,
        @Query("period") period: String = CoinPeriod.PERIOD_24H.period
    ): ChartResponseModel

    @GET("v1/news/{filter}")
    suspend fun getNews(
        @Path("filter") filter: String,
        @Query("limit") limit: Int = 20,
        @Query("skip") skip: Int = 0
    ): NewsResponseModel
}