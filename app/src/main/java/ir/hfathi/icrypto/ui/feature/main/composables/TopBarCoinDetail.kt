package ir.hfathi.icrypto.ui.feature.main.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import ir.hfathi.icrypto.ui.theme.*

@Composable
fun TopBarCoinDetail(
    coinSymbol: String,
    icon: String,

) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = DP_16)
            .requiredHeight(DP_40),
        contentAlignment = Alignment.Center,
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            AsyncImage(
                model = icon,
                contentDescription = stringResource(id = ir.hfathi.icrypto.R.string.icon),
                modifier = Modifier
                    .size(DP_30)
                    .padding(end = DP_5)
            )

            Text(
                text = coinSymbol,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6,
                color = TextWhite,
            )
        }
    }

}