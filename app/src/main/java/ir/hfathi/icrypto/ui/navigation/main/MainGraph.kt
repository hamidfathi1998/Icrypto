package ir.hfathi.icrypto.ui.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.hfathi.icrypto.ui.feature.home.HomeViewModel
import ir.hfathi.icrypto.ui.feature.home.composables.HomeScreen
import ir.hfathi.icrypto.ui.feature.news.composables.NewsScreen
import ir.hfathi.icrypto.ui.feature.watchList.composables.WatchListScreen
import ir.hfathi.icrypto.ui.navigation.root.Graph
import org.koin.androidx.compose.getViewModel

@Composable
fun MainGraph(
    navController: NavHostController,
    openBottomSheet: () -> Unit
) {
    val homeViewModel = getViewModel<HomeViewModel>()

    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = Screens.CoinsScreen.route
    ) {
        composable(
            route = Screens.CoinsWatchList.route
        ) {
            WatchListScreen()
        }

        composable(
            route = Screens.CoinsScreen.route
        ) {
            HomeScreen(
                state = homeViewModel.viewState.value,
                onEventSent = { event -> homeViewModel.setEvent(event) },
                openBottomSheet = openBottomSheet
            )
        }

        composable(
            route = Screens.CoinsNews.route
        ) {
            NewsScreen()
        }

    }
}