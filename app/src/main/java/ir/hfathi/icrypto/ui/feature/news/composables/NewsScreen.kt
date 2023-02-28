package ir.hfathi.icrypto.ui.feature.news.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import ir.hfathi.icrypto.ui.theme.DP_20
import ir.hfathi.icrypto.ui.theme.TextWhite

@Composable
fun NewsScreen() {
    Text(
        text = stringResource(id = ir.hfathi.icrypto.R.string.newsScreen),
        color = TextWhite,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = DP_20)
    )

}
