package ir.hfathi.icrypto.ui.feature.main.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import ir.hfathi.icrypto.ui.theme.DP_12
import ir.hfathi.icrypto.ui.theme.TextWhite
import ir.hfathi.icrypto.R

@Composable
fun CoinInformation(
    modifier: Modifier = Modifier,
    volume: String,
    marketCap: String,
    availableSupply: String,
    totalSupply: String,
    rank: String
) {
    Column(modifier = modifier) {
        CoinInfoRow(value = rank, title = stringResource(id = R.string.rank))
        CoinInfoRow(value = marketCap, title = stringResource(id = R.string.marketCap))
        CoinInfoRow(value = volume, title = stringResource(id = R.string.volume))
        CoinInfoRow(value = availableSupply, title = stringResource(id = R.string.availableSupply))
        CoinInfoRow(value = totalSupply, title = stringResource(id = R.string.totalSupply))
    }
}

@Composable
fun CoinInfoRow(
    value: String,
    title: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
        .fillMaxWidth()
    ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = TextWhite,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(bottom = DP_12)
            )

                Text(
                    text = value,
                    color = TextWhite,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.body2
                )

        }
    }
