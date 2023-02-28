package ir.hfathi.icrypto.model.repository

import ir.hfathi.icrypto.model.model.dto.ChartDto
import ir.hfathi.icrypto.model.model.dto.CoinDetailDto
import ir.hfathi.icrypto.model.model.dto.CoinsDto
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

    override suspend fun getCoins(): Result<CoinsDto> =
        makeApiCall(dispatcher = dispatcher) { coinApi.getCoins() }

    override suspend fun getCoinById(coinId: String): Result<CoinDetailDto> =
        makeApiCall(dispatcher = dispatcher) { coinApi.getCoinById(coinId = coinId) }

    override suspend fun getChartsData(coinId: String): Result<ChartDto> =
        makeApiCall(dispatcher = dispatcher) { coinApi.getChartsData(coinId = coinId) }

    override fun getStreamCryptoPrice(data: MutableStateFlow<CoinPriceResponseModel>) {
        val webSocket = CoinWebSocketClient(data = data)
        webSocket.connectionLostTimeout = 300
        webSocket.connect()
    }

}