package ir.hfathi.icrypto.ui.feature.news

import androidx.lifecycle.viewModelScope
import ir.hfathi.icrypto.model.repository.CoinRepository
import ir.hfathi.icrypto.ui.base.BaseViewModel
import kotlinx.coroutines.launch


class NewsViewModel(private val coinRepository: CoinRepository) :
    BaseViewModel<NewsContract.Event, NewsContract.State, NewsContract.Effect>() {

    init {
        getAllNewsData()
    }

    override fun setInitialState() = NewsContract.State(
        isPullToRefresh = false,
        isLoading = true,
        isError = false,
    )

    override fun handleEvents(event: NewsContract.Event) {
        when (event) {
            is NewsContract.Event.BackButtonClicked -> {
                setEffect { NewsContract.Effect.Navigation.Back }
            }
            is NewsContract.Event.PullToRefresh -> pullToRefresh()
            is NewsContract.Event.Retry -> retryGetData()
        }
    }


    private fun retryGetData() {
        setState { copy(isLoading = true, isError = false, isPullToRefresh = false) }
        getAllNewsData()
    }

    private fun pullToRefresh() {
        setState { copy(isLoading = false, isError = false, isPullToRefresh = true) }
        getAllNewsData()
    }

    private fun getAllNewsData() {
        viewModelScope.launch {
            coinRepository.getNewsData()
                .onSuccess { newsResponseModel ->
                    setState { copy(allNewsData = newsResponseModel, isLoading = false, isPullToRefresh = false) }
                }
                .onFailure {
                    setState { copy(isError = true, isLoading = false, isPullToRefresh = false) }
                }
        }
    }
}