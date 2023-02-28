package ir.hfathi.icrypto.model.api

import ir.hfathi.icrypto.model.api.Endpoints.GET_CHART_DATA
import ir.hfathi.icrypto.model.api.Endpoints.GET_COINS_ENDPOINTS
import ir.hfathi.icrypto.model.api.Endpoints.GET_SPECIAL_COIN
import ir.hfathi.icrypto.model.model.response.ChartResponseModel
import ir.hfathi.icrypto.model.model.response.CoinDetailResponseModel
import ir.hfathi.icrypto.model.model.response.CoinsResponseModel
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
        @Query("period") period: String = CoinPeriod.PERIOD_24h.period
    ): ChartResponseModel


}