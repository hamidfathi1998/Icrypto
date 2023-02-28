package ir.hfathi.icrypto.ui.feature.home

import androidx.lifecycle.viewModelScope
import ir.hfathi.icrypto.model.model.response.CoinPriceResponseModel
import ir.hfathi.icrypto.model.model.response.Coins
import ir.hfathi.icrypto.model.repository.CoinRepository
import ir.hfathi.icrypto.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val coinRepository: CoinRepository
) : BaseViewModel<HomeContract.Event, HomeContract.State, HomeContract.Effect>() {
    var coinStreamData = MutableStateFlow(CoinPriceResponseModel())

    init {
        getAll()
    }

    override fun setInitialState() = HomeContract.State(
        coinInformationData = arrayListOf(),
        coinDetailsData = null,
        coinChartData = null,
        isPullToRefresh = false,
        isError = false,
        isLoading = true,
        isCoinDetailLoading = false
    )

    override fun handleEvents(event: HomeContract.Event) {
        when (event) {
            is HomeContract.Event.BackButtonClicked -> {
                setEffect { HomeContract.Effect.Navigation.Back }
            }
            is HomeContract.Event.PullToRefresh -> pullToRefresh()
            is HomeContract.Event.CoinSelection -> getCoinDetails(event.coin)
            is HomeContract.Event.Retry -> getAll()
        }
    }

    private fun getAll() {
        viewModelScope.launch {
            getCoinPrice()
            getCoinInformation()
        }
    }

    private fun getCoinDetails(coin: Coins) {
        viewModelScope.launch {
            setState { copy(isCoinDetailLoading = true, isLoading = false, isError = false) }

            coinRepository.getCoinById(coin.id)
                .onSuccess { coinDetailDto ->
                    setState { copy(coinDetailsData = coinDetailDto, isCoinDetailLoading = false) }
                }
                .onFailure {
                    setState { copy(isError = true, isCoinDetailLoading = false) }
                }

            coinRepository.getChartsData(coin.id)
                .onSuccess { chartDto ->
                    setState { copy(coinChartData = chartDto, isCoinDetailLoading = false) }
                }
                .onFailure {
                    setState { copy(isError = true, isCoinDetailLoading = false) }
                }
        }
    }

    private fun getCoinInformation() {
        viewModelScope.launch {
            setState { copy(isLoading = true, isError = false, isPullToRefresh = false) }

            coinRepository.getCoins()
                .onSuccess { coinsList ->
                    setState { copy(coinInformationData = coinsList.coins, isLoading = false) }
                }
                .onFailure {
                    setState { copy(isError = true, isLoading = false) }
                }
        }
    }

    private fun getCoinPrice() {
        coinRepository.getStreamCryptoPrice(data = coinStreamData)
    }

    private fun pullToRefresh() {
        setState { copy(isPullToRefresh = true, isLoading = false, isError = false) }
        getAll()
    }
}

