package ir.hfathi.icrypto.core.util

import android.content.Intent
import android.net.Uri
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

fun buildUrlIntent(url: String) = Intent(Intent.ACTION_VIEW, Uri.parse(url))

suspend fun <T> makeApiCall(
    dispatcher: CoroutineDispatcher,
    call: suspend () -> T
): Result<T> = runCatching {
    withContext(dispatcher) {
        call.invoke()
    }
}