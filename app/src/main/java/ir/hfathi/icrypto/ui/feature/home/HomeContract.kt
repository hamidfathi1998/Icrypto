package ir.hfathi.icrypto.ui.feature.home

import ir.hfathi.icrypto.model.model.response.chart.ChartResponseModel
import ir.hfathi.icrypto.model.model.response.coin.Coin
import ir.hfathi.icrypto.model.model.response.coin.CoinDetailResponseModel
import ir.hfathi.icrypto.model.model.response.coin.Coins
import ir.hfathi.icrypto.ui.base.ViewEvent
import ir.hfathi.icrypto.ui.base.ViewSideEffect
import ir.hfathi.icrypto.ui.base.ViewState

class HomeContract {

    sealed class Event : ViewEvent {
        object Retry : Event()
        object BackButtonClicked : Event()
        object PullToRefresh : Event()
        data class CoinSelection(val coin: Coins) : Event()
    }

    data class State(
        val coinInformationData: List<Coin>,
        val coinDetailsData: CoinDetailResponseModel?,
        val coinChartData: ChartResponseModel?,
        val isPullToRefresh: Boolean,
        val isError: Boolean,
        val isLoading: Boolean,
        val isCoinDetailLoading: Boolean
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object Back : Navigation()
        }
    }

}