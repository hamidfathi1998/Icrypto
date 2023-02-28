package ir.hfathi.icrypto.ui.feature.news.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.hfathi.icrypto.ui.theme.TextWhite

@Composable
fun NewsScreen() {
    Text(
        text = "News Screen",
        color = TextWhite,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    )

}
