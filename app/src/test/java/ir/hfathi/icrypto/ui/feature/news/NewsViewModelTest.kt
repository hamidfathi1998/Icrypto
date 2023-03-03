package ir.hfathi.icrypto.ui.feature.news

import io.mockk.coEvery
import io.mockk.mockk
import ir.hfathi.icrypto.model.model.response.news.NewsResponseModel
import ir.hfathi.icrypto.model.repository.CoinRepository
import ir.hfathi.icrypto.utils.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class NewsViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()
    private val githubRepository = mockk<CoinRepository>()

    @Test
    fun `When view model initialized then should emit initial view state first`() = runTest {
        val expectedInitialViewState = NewsContract.State(
            isPullToRefresh = false,
            isLoading = true,
            isError = false,
        )
        val viewModel = NewsViewModel(githubRepository)
        assertEquals(expectedInitialViewState, viewModel.viewState.value)
    }

    @Test
    fun `When getCoins called then should emit a view state`() = runTest {
        val news = NewsResponseModel(listOf())
        val expectedViewState = NewsContract.State(
            allNewsData = NewsResponseModel(listOf()),
            isPullToRefresh = false,
            isLoading = false,
            isError = false,
        )
        coEvery { githubRepository.getNewsData() } returns Result.success(news)
        val viewModel = NewsViewModel(githubRepository)
        assertEquals(expectedViewState, viewModel.viewState.value)
    }
}