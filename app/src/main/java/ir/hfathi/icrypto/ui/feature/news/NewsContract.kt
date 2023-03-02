package ir.hfathi.icrypto.ui.feature.news

import ir.hfathi.icrypto.model.model.response.news.NewsResponseModel
import ir.hfathi.icrypto.ui.base.ViewEvent
import ir.hfathi.icrypto.ui.base.ViewSideEffect
import ir.hfathi.icrypto.ui.base.ViewState

class NewsContract {

    sealed class Event : ViewEvent {
        object Retry : Event()
        object BackButtonClicked : Event()
        object PullToRefresh : Event()
    }

    data class State(
        val allNewsData: NewsResponseModel? = null,
        val isPullToRefresh: Boolean,
        val isError: Boolean,
        val isLoading: Boolean,
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object Back : Navigation()
        }
    }

}