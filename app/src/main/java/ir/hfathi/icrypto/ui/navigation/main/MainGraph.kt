package ir.hfathi.icrypto.ui.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.hfathi.icrypto.ui.feature.coin.CoinScreen
import ir.hfathi.icrypto.ui.feature.news.NewsScreen
import ir.hfathi.icrypto.ui.feature.watchList.WatchListScreen
import ir.hfathi.icrypto.ui.navigation.root.Graph

@Composable
fun MainGraph(navController: NavHostController) {
    
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = Screens.CoinsScreen.route
    ) {
        composable(
            route = Screens.CoinsWatchList.route
        ){
            WatchListScreen()
        }

        composable(
            route = Screens.CoinsScreen.route
        ){
            CoinScreen()
        }

        composable(
            route = Screens.CoinsNews.route
        ){
            NewsScreen()
        }

    }
}