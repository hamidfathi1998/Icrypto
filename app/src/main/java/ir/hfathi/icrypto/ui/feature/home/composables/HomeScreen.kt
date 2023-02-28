package ir.hfathi.icrypto.ui.feature.home.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ir.hfathi.icrypto.ui.feature.home.HomeContract
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
                title = "Live Prices",
            )
        },
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

}

