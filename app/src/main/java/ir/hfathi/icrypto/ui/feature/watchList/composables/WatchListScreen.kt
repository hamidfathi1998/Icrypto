package ir.hfathi.icrypto.ui.feature.watchList.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import ir.hfathi.icrypto.R
import ir.hfathi.icrypto.ui.theme.DP_20
import ir.hfathi.icrypto.ui.theme.TextWhite

@Composable
fun WatchListScreen() {
    Text(
        text = stringResource(id = R.string.watchListScreen),
        color = TextWhite,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DP_20)
    )
}
