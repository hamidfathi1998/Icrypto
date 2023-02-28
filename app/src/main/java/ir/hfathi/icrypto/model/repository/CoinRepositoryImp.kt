package ir.hfathi.icrypto.model.repository

import ir.hfathi.icrypto.model.model.response.ChartResponseModel
import ir.hfathi.icrypto.model.model.response.CoinDetailResponseModel
import ir.hfathi.icrypto.model.model.response.CoinsResponseModel
import ir.hfathi.icrypto.core.util.makeApiCall
import ir.hfathi.icrypto.model.api.CoinApi
import ir.hfathi.icrypto.model.model.response.CoinPriceResponseModel
import ir.hfathi.icrypto.model.remote.CoinWebSocketClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow

class CoinRepositoryImp(
    private val coinApi: CoinApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : CoinRepository {

    override suspend fun getCoins(): Result<CoinsResponseModel> =
        makeApiCall(dispatcher = dispatcher) { coinApi.getCoins() }

    override suspend fun getCoinById(coinId: String): Result<CoinDetailResponseModel> =
        makeApiCall(dispatcher = dispatcher) { coinApi.getCoinById(coinId = coinId) }

    override suspend fun getChartsData(coinId: String): Result<ChartResponseModel> =
        makeApiCall(dispatcher = dispatcher) { coinApi.getChartsData(coinId = coinId) }

    override fun getStreamCryptoPrice(data: MutableStateFlow<CoinPriceResponseModel>) {
        val webSocket = CoinWebSocketClient(data = data)
        webSocket.connectionLostTimeout = 300
        webSocket.connect()
    }

}