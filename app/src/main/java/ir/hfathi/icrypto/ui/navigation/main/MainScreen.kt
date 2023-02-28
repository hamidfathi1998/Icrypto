package ir.hfathi.icrypto.ui.navigation.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ir.hfathi.icrypto.ui.feature.main.composables.CoinDetailsBottomSheetContent
import ir.hfathi.icrypto.ui.feature.main.composables.MainBottomBarContent
import ir.hfathi.icrypto.ui.theme.LighterGray
import ir.hfathi.icrypto.ui.theme.TextWhite
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState =
        rememberModalBottomSheetState(
            initialValue = ModalBottomSheetValue.Hidden,
            skipHalfExpanded = true
        )

    ModalBottomSheetLayout(
        sheetContent = { CoinDetailsBottomSheetContent() },
        sheetState = bottomSheetState
    ) {
        Scaffold(
            bottomBar = { MainBottomBarContent(navController = navController) }
        ) {
            MainGraph(navController = navController, openBottomSheet = {
                coroutineScope.launch {
                    bottomSheetState.show()
                }
            })
            it
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    state: MutableState<Boolean>,
    modifier: Modifier = Modifier
) {
    val screens = listOf(
        Screens.CoinsWatchList,
        Screens.CoinsScreen,
        Screens.CoinsNews
    )

    AnimatedVisibility(
        visible = state.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
    ) {
        BottomNavigation(
            modifier = modifier,
            backgroundColor = LighterGray,
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            screens.forEach { screen ->

                BottomNavigationItem(
                    label = {
                        Text(text = screen.title!!)
                    },
                    icon = {
                        Icon(imageVector = screen.icon!!, contentDescription = null)
                    },

                    selected = currentRoute == screen.route,

                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    alwaysShowLabel = false,
                    selectedContentColor = TextWhite,
                    unselectedContentColor = TextWhite.copy(alpha = ContentAlpha.disabled)
                )
            }
        }
    }

}

