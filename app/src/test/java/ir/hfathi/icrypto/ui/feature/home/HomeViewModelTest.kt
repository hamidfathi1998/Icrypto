package ir.hfathi.icrypto.ui.feature.home

import io.mockk.coEvery
import io.mockk.mockk
import ir.hfathi.icrypto.model.model.response.chart.ChartResponseModel
import ir.hfathi.icrypto.model.model.response.coin.CoinDetailResponseModel
import ir.hfathi.icrypto.model.model.response.coin.CoinsResponseModel
import ir.hfathi.icrypto.model.repository.CoinRepository
import ir.hfathi.icrypto.utils.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()
    private val githubRepository = mockk<CoinRepository>()

    @Test
    fun `When view model initialized then should emit initial view state first`() = runTest {
        val expectedInitialViewState = HomeContract.State(
            coinInformationData = arrayListOf(),
            coinDetailsData = null,
            coinChartData = null,
            isPullToRefresh = false,
            isError = false,
            isLoading = true,
            isCoinDetailLoading = false
        )
        val viewModel = HomeViewModel(githubRepository)
        assertEquals(expectedInitialViewState, viewModel.viewState.value)
    }

    @Test
    fun `When getCoins called then should emit a view state`() = runTest {
        val coins = CoinsResponseModel(listOf())
        val expectedViewState = HomeContract.State(
            coinInformationData = arrayListOf(),
            coinDetailsData = null,
            coinChartData = null,
            isPullToRefresh = false,
            isError = false,
            isLoading = true,
            isCoinDetailLoading = false
        )
        coEvery { githubRepository.getCoins() } returns Result.success(coins)
        val viewModel = HomeViewModel(githubRepository)
        assertEquals(expectedViewState, viewModel.viewState.value)
    }

    @Test
    fun `When getCoinById called then should emit a view state`() = runTest {
        val coins = mockk<CoinDetailResponseModel>()
        val expectedViewState = HomeContract.State(
            coinInformationData = arrayListOf(),
            coinDetailsData = null,
            coinChartData = null,
            isPullToRefresh = false,
            isError = false,
            isLoading = true,
            isCoinDetailLoading = false
        )
        coEvery { githubRepository.getCoinById(coinId = "hamid fathi") } returns Result.success(coins)
        val viewModel = HomeViewModel(githubRepository)
        assertEquals(expectedViewState, viewModel.viewState.value)
    }

    @Test
    fun `When getChartsData called then should emit a view state`() = runTest {
        val coins = ChartResponseModel(listOf())
        val expectedViewState = HomeContract.State(
            coinInformationData = arrayListOf(),
            coinDetailsData = null,
            coinChartData = null,
            isPullToRefresh = false,
            isError = false,
            isLoading = true,
            isCoinDetailLoading = false
        )
        coEvery { githubRepository.getChartsData(coinId = "hamid fathi") } returns Result.success(coins)
        val viewModel = HomeViewModel(githubRepository)
        assertEquals(expectedViewState, viewModel.viewState.value)
    }
}