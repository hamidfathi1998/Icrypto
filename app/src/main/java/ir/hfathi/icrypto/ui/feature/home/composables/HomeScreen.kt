package ir.hfathi.icrypto.ui.feature.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.hfathi.icrypto.R
import ir.hfathi.icrypto.ui.feature.common.NetworkError
import ir.hfathi.icrypto.ui.feature.home.HomeContract
import ir.hfathi.icrypto.ui.feature.home.composables.shimmer.HomeShimmerContent
import ir.hfathi.icrypto.ui.theme.DarkGray


@Composable
fun HomeScreen(
    state: HomeContract.State,
    onEventSent: (event: HomeContract.Event) -> Unit,
    openBottomSheet: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            CoinsScreenTopBar(
                title = stringResource(id = R.string.livePrices),
            )
        },
    ) {
        when {
            state.isLoading || state.isPullToRefresh -> HomeShimmerContent()
            state.isError -> NetworkError { onEventSent(HomeContract.Event.Retry) }
            else -> HomeScreenContent(
                state = state,
                onEventSent = onEventSent,
                openBottomSheet = openBottomSheet
            )
        }
    }
}

@Composable
fun HomeScreenContent(
    state: HomeContract.State,
    onEventSent: (event: HomeContract.Event) -> Unit,
    openBottomSheet: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(DarkGray)
            .fillMaxSize()
    ) {
        Column {
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = state.isPullToRefresh),
                onRefresh = { onEventSent(HomeContract.Event.PullToRefresh) }) {
                CoinList(
                    state = state,
                    onEventSent = onEventSent,
                    openBottomSheet = openBottomSheet
                )
            }
        }
    }
}

