package ir.hfathi.icrypto

import android.app.Application
import ir.hfathi.icrypto.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ICryptoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ICryptoApplication)
            modules(appModules)
        }

    }
}
