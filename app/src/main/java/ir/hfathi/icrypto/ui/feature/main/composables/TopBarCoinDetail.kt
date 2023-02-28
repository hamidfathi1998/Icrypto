package ir.hfathi.icrypto.ui.feature.main.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ir.hfathi.icrypto.ui.theme.TextWhite

@Composable
fun TopBarCoinDetail(
    coinSymbol: String,
    icon: String,

) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .requiredHeight(40.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            AsyncImage(
                model = icon,
                contentDescription = "Icon",
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 5.dp)
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