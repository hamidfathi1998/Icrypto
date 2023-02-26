package ir.hfathi.icrypto.di

import ir.hfathi.icrypto.model.api.CoinApi
import ir.hfathi.icrypto.model.api.Endpoints
import ir.hfathi.icrypto.model.repository.viewModelModule
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.dsl.module

val appModule = module {

    single {
        OkHttpClient.Builder().build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(Endpoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(CoinApi::class.java)
    }

}

val appModules = listOf(
    appModule,
    repositoryModule,
    viewModelModule
)