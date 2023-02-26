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
        route = "coins_watch_list",
        title = "WatchList",
        icon = Icons.Default.Favorite
    )

    object CoinsScreen: Screens(
        route = "coins_screen",
        title = "Home",
        icon = Icons.Default.Home
    )

    object CoinsNews: Screens(
        route = "coins_news",
        title = "News",
        icon = Icons.Outlined.Info
    )

}
