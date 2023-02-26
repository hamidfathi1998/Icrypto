package ir.hfathi.icrypto.di

import ir.hfathi.icrypto.model.repository.CoinRepository
import ir.hfathi.icrypto.model.repository.CoinRepositoryImp
import org.koin.dsl.module

val repositoryModule = module {

    factory<CoinRepository> {
        CoinRepositoryImp(
            coinApi = get()
        )
    }

}