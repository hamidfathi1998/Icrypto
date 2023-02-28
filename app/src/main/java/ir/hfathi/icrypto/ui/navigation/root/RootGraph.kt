package ir.hfathi.icrypto.ui.navigation.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.hfathi.icrypto.ui.navigation.main.MainScreen

@Composable
fun RootNavigationGraph(navHostController: NavHostController){

    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.MAIN
    ) {
        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}

