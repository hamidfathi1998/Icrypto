package ir.hfathi.icrypto.ui.main

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ir.hfathi.icrypto.ui.navigation.root.RootNavigationGraph
import ir.hfathi.icrypto.ui.theme.IcryptoTheme
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI
import java.net.URISyntaxException

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IcryptoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RootNavigationGraph(
                        navHostController = rememberNavController(),
                    )
                }
            }
        }
    }

    private var mWebSocketClient: WebSocketClient? = null
    private fun connectWebSocket() {
        val uri: URI
        try {
            uri = URI("wss://ws.postman-echo.com/raw")
        } catch (e: URISyntaxException) {
            e.printStackTrace()
            return
        }
        mWebSocketClient = object : WebSocketClient(uri) {
            override fun onOpen(serverHandshake: ServerHandshake) {
                Log.i("Websocket", "Opened")
                mWebSocketClient?.send("Hello from " + Build.MANUFACTURER + " " + Build.MODEL)
            }

            override fun onMessage(s: String) {
                runOnUiThread {
                    Log.e("hamid", "onMessage: $s")
                }
                sendMessage()
            }

            override fun onClose(i: Int, s: String, b: Boolean) {
                Log.i("Websocket", "Closed $s")
            }

            override fun onError(e: Exception) {
                Log.i("Websocket", "Error " + e.message)
            }
        }
        mWebSocketClient?.connect()
    }

    fun sendMessage() {
        mWebSocketClient!!.send("Hi hamid")
    }
}
//
//// Adding authentication headers when encountering EVENT_TRANSPORT
//mSocket.io().on(Manager.EVENT_TRANSPORT, new Emitter.Listener() {
//    @Override
//    public void call(Object... args) {
//        Transport transport = (Transport) args[0];
//        // Adding headers when EVENT_REQUEST_HEADERS is called
//        transport.on(Transport.EVENT_REQUEST_HEADERS, new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//            Log.v(TAG, "Caught EVENT_REQUEST_HEADERS after EVENT_TRANSPORT, adding headers");
//            Map<String, List<String>> mHeaders = (Map<String, List<String>>)args[0];
//            mHeaders.put("Authorization", Arrays.asList("Basic bXl1c2VyOm15cGFzczEyMw=="));
//        }
//        });
//    }
//});