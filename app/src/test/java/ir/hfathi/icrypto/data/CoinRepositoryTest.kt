package ir.hfathi.icrypto.data

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import ir.hfathi.icrypto.model.api.CoinApi
import ir.hfathi.icrypto.model.api.enumType.NewsFilterType
import ir.hfathi.icrypto.model.model.response.chart.ChartResponseModel
import ir.hfathi.icrypto.model.model.response.coin.CoinDetailResponseModel
import ir.hfathi.icrypto.model.model.response.coin.CoinsResponseModel
import ir.hfathi.icrypto.model.model.response.news.NewsResponseModel
import ir.hfathi.icrypto.model.repository.CoinRepository
import ir.hfathi.icrypto.model.repository.CoinRepositoryImp
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CoinRepositoryTest {

    private val coinApi = mockk<CoinApi>()
    private val coinRepository: CoinRepository = CoinRepositoryImp(coinApi)

    @Test
    fun `When getCoins called then should call getCoins from the API`() = runTest {
        val coinsResponseModel = CoinsResponseModel(listOf())
        coEvery { coinApi.getCoins() } returns coinsResponseModel

        val result = coinRepository.getCoins()

        assert(result.isSuccess)
        coVerify(exactly = 1) { coinApi.getCoins() }
        confirmVerified(coinApi)
    }

    @Test
    fun `When getCoinById called then should call getCoinById from the API`() = runTest {
        val coinDetailResponseModel = mockk<CoinDetailResponseModel>()
        val coinId = "1"
        coEvery { coinApi.getCoinById(coinId = coinId) } returns coinDetailResponseModel

        val result = coinRepository.getCoinById(coinId = coinId)

        assert(result.isSuccess)
        coVerify(exactly = 1) { coinApi.getCoinById(coinId = coinId) }
        confirmVerified(coinApi)
    }

    @Test
    fun `When getChartsData called then should call getChartsData from the API`() = runTest {
        val chartResponseModel = mockk<ChartResponseModel>()
        val coinId = "1"
        coEvery { coinApi.getChartsData(coinId = coinId) } returns chartResponseModel

        val result = coinRepository.getChartsData(coinId = coinId)

        assert(result.isSuccess)
        coVerify(exactly = 1) { coinApi.getChartsData(coinId = coinId) }
        confirmVerified(coinApi)
    }


    @Test
    fun `When getNews called then should call getNews from the API`() = runTest {
        val newsResponseModel = NewsResponseModel(listOf())
        coEvery {
            coinApi.getNews(
                filter = NewsFilterType.TRENDING.value
            )
        } returns newsResponseModel

        val result = coinRepository.getNewsData()

        assert(result.isSuccess)
        coVerify(exactly = 1) { coinApi.getNews(filter = NewsFilterType.TRENDING.value) }
        confirmVerified(coinApi)
    }

    @Test
    fun `Given an exception When getCoins called then returns failure`() = runTest {
        coEvery { coinApi.getCoins() } throws Exception("")
        val result = coinRepository.getCoins()
        assert(result.isFailure)
    }


    @Test
    fun `Given an exception When getCoinById called then returns failure`() = runTest {
        coEvery { coinApi.getCoinById(any()) } throws Exception("")
        val result = coinRepository.getCoinById("hamid fathi")
        assert(result.isFailure)
    }


    @Test
    fun `Given an exception When getChartsData called then returns failure`() = runTest {
        coEvery { coinApi.getChartsData(any()) } throws Exception("")
        val result = coinRepository.getChartsData("hamid fathi")
        assert(result.isFailure)
    }

    @Test
    fun `Given an exception When getNews called then returns failure`() = runTest {
        coEvery { coinApi.getNews(any()) } throws Exception("")
        val result = coinRepository.getNewsData("hamid fathi")
        assert(result.isFailure)
    }
}