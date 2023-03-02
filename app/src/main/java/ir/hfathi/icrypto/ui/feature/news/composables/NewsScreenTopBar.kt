package ir.hfathi.icrypto.ui.feature.news.composables


import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import ir.hfathi.icrypto.R
import ir.hfathi.icrypto.ui.theme.*

@Composable
fun NewsScreenTopBar() {
    Box(Modifier.fillMaxWidth().padding(top = DP_30)) {
        Text(
            text = stringResource(id = R.string.news),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6,
            color = TextWhite,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun NewsScreenTopBarPreview() {
    NewsScreenTopBar()
}