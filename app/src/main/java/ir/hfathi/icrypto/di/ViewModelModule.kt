package ir.hfathi.icrypto.di

import ir.hfathi.icrypto.ui.feature.home.HomeViewModel
import ir.hfathi.icrypto.ui.feature.news.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(
            coinRepository = get()
        )
    }

    viewModel {
        NewsViewModel(
            coinRepository = get()
        )
    }
}
