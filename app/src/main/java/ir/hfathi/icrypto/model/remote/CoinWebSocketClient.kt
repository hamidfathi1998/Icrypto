package ir.hfathi.icrypto.model.remote

import ir.hfathi.icrypto.model.model.provider.CoinStreamModelConvertor
import ir.hfathi.icrypto.model.model.response.coin.CoinPriceResponseModel
import ir.hfathi.icrypto.model.remote.SocketApi.SOCKET_URL
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.lang.Exception
import java.net.URI

class CoinWebSocketClient(
    serverUri: URI? = URI(SOCKET_URL),
    private val data: MutableStateFlow<CoinPriceResponseModel>,
) :
    WebSocketClient(serverUri) {

    var firstTimeFlag = true

    override fun onOpen(handshakedata: ServerHandshake) {
        send(CoinStreamModelConvertor().get())
    }

    override fun onMessage(message: String) {
        if (!firstTimeFlag) {
            data.value = CoinStreamModelConvertor().set(response = message)
        } else {
            firstTimeFlag = false
        }
    }

    override fun onClose(code: Int, reason: String, remote: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            reconnect()
        }
    }

    override fun onError(ex: Exception) {
        ex.printStackTrace()
    }
}