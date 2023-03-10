package ir.hfathi.icrypto.ui.feature.home.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ir.hfathi.icrypto.model.model.request.symbolContainStreamCoinArg
import ir.hfathi.icrypto.ui.feature.home.HomeContract
import ir.hfathi.icrypto.ui.feature.home.HomeViewModel
import ir.hfathi.icrypto.ui.theme.DP_56
import org.koin.androidx.compose.getViewModel

@Composable
fun CoinList(
    state: HomeContract.State,
    onEventSent: (event: HomeContract.Event) -> Unit,
    openBottomSheet: () -> Unit
) {
    val lazyListState = rememberLazyListState()
    val homeViewModel = getViewModel<HomeViewModel>()

    LazyColumn(
        modifier = Modifier.padding(bottom = DP_56),
        state = lazyListState
    ) {
        items(items = state.coinInformationData) { coins ->
            if (symbolContainStreamCoinArg(coins.symbol)) {
                CoinListItem(
                    coins = coins,
                    homeViewModel = homeViewModel,
                    onEventSent = onEventSent,
                    openBottomSheet = openBottomSheet
                )
            }
        }
    }
}

