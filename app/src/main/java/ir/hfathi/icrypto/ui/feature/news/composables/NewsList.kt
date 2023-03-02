package ir.hfathi.icrypto.ui.feature.news.composables


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalUriHandler
import ir.hfathi.icrypto.ui.feature.news.NewsContract

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NewsList(
    state: NewsContract.State
) {
    val uriHandler = LocalUriHandler.current
    LazyColumn {
        items(items = state.allNewsData?.news ?: listOf()) { news ->
            NewsCard(
                newsThumb = news.imgURL,
                title = news.title,
                onClick = {
                    uriHandler.openUri(news.link)
                }
            )
        }
    }
}