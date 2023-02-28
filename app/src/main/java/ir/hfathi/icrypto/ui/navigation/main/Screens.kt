package ir.hfathi.icrypto.ui.navigation.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(
    val route: String,
    val title: String?= null,
    val icon: ImageVector?= null
    ) {
    object CoinsWatchList: Screens(
        route = ScreensRoute.WATCH_LIST.route,
        title = ScreensRoute.WATCH_LIST.title,
        icon = Icons.Default.Favorite
    )

    object CoinsScreen: Screens(
        route = ScreensRoute.HOME.route,
        title = ScreensRoute.HOME.title,
        icon = Icons.Default.Home
    )

    object CoinsNews: Screens(
        route = ScreensRoute.NEWS.route,
        title = ScreensRoute.NEWS.title,
        icon = Icons.Outlined.Info
    )

}
