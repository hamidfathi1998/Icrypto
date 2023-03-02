package ir.hfathi.icrypto.ui.feature.news.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.hfathi.icrypto.ui.feature.common.NetworkError
import ir.hfathi.icrypto.ui.feature.news.NewsContract
import ir.hfathi.icrypto.ui.feature.news.NewsViewModel
import ir.hfathi.icrypto.ui.feature.news.composables.shimmer.NewsShimmerContent
import ir.hfathi.icrypto.ui.theme.DP_12
import ir.hfathi.icrypto.ui.theme.DarkGray

@ExperimentalMaterialApi
@Composable
fun NewsScreen(
    onEventSent: (event: NewsContract.Event) -> Unit,
    state: NewsContract.State
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            NewsScreenTopBar()
        },
    ) { padding ->
        when {
            state.isLoading || state.isPullToRefresh -> NewsShimmerContent()
            state.isError -> NetworkError { onEventSent(NewsContract.Event.Retry) }
            else -> NewsScreenContent(
                contentPadding = padding,
                onEventSent = onEventSent,
                state = state
            )
        }
    }
}

@Composable
fun NewsScreenContent(
    onEventSent: (event: NewsContract.Event) -> Unit,
    state: NewsContract.State,
    contentPadding: PaddingValues
) {
    Box(
        modifier = Modifier
            .background(DarkGray)
            .fillMaxSize()
            .padding(DP_12)
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = state.isPullToRefresh),
            onRefresh = { onEventSent(NewsContract.Event.PullToRefresh) }) {
            NewsList(state = state)
        }
    }
}
