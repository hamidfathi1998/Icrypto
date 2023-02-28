package ir.hfathi.icrypto.ui.feature.main.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ir.hfathi.icrypto.ui.navigation.main.BottomBar
import ir.hfathi.icrypto.ui.theme.DP_56
import kotlin.math.roundToInt

@Composable
fun MainBottomBarContent(navController: NavHostController = rememberNavController()) {
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val bottomBarHeight = DP_56
    val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }
    BottomBar(
        navController = navController,
        state = bottomBarState,
        modifier = Modifier
            .height(bottomBarHeight)
            .offset {
                IntOffset(
                    x = 0,
                    y = -bottomBarOffsetHeightPx.value.roundToInt()
                )
            }
    )
}