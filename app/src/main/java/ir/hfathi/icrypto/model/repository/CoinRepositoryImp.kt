package ir.hfathi.icrypto.model.repository

import ir.hfathi.icrypto.core.util.makeApiCall
import ir.hfathi.icrypto.model.api.CoinApi
import ir.hfathi.icrypto.model.model.CoinChartModel
import ir.hfathi.icrypto.model.model.CoinDetailModel
import ir.hfathi.icrypto.model.model.CoinModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CoinRepositoryImp(
    private val coinApi: CoinApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : CoinRepository {

    override suspend fun getAllCryptoCurrency(): Result<List<CoinModel>> =
        makeApiCall(dispatcher = dispatcher) { coinApi.getAllCryptoCurrency() }

    override suspend fun getSpecificCryptoDetails(coinId: String): Result<CoinDetailModel> =
        makeApiCall(dispatcher = dispatcher) { coinApi.getSpecificCryptoDetails(coinId = coinId) }

    override suspend fun getCryptoChartData(coinId: String): Result<CoinChartModel> =
        makeApiCall(dispatcher = dispatcher) { coinApi.getCryptoChartData(coinId = coinId) }

}