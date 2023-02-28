package ir.hfathi.icrypto.ui.feature.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import ir.hfathi.icrypto.ui.navigation.root.RootNavigationGraph
import ir.hfathi.icrypto.ui.theme.IcryptoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
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

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }

}
