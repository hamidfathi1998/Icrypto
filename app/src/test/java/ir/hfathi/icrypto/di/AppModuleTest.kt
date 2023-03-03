package ir.hfathi.icrypto.di

import ir.hfathi.icrypto.ui.feature.home.HomeViewModel
import ir.hfathi.icrypto.ui.feature.news.NewsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.dsl.koinApplication
import org.koin.test.check.checkModules

@OptIn(ExperimentalCoroutinesApi::class)
class AppModuleTest {

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `verify koin app`() {
        koinApplication {
            modules(appModule, repositoryModule, viewModelModule)
            checkModules {
                withParameter<HomeViewModel> {}
                withParameter<NewsViewModel> {}
            }
        }
    }
}