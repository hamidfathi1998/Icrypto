package ir.hfathi.icrypto.ui.feature.home.composables


import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import ir.hfathi.icrypto.ui.theme.DP_24
import ir.hfathi.icrypto.ui.theme.DP_32
import ir.hfathi.icrypto.ui.theme.TextWhite

@Composable
fun CoinsScreenTopBar(
    title: String,
    modifier: Modifier = Modifier,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = DP_24)
    ) {

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = stringResource(id = ir.hfathi.icrypto.R.string.toggle),
            )
        }

        Box(Modifier.fillMaxWidth()) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6,
                color = TextWhite,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(end = DP_32)
            )
        }

    }

}