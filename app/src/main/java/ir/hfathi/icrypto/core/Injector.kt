package ir.hfathi.icrypto.core

import org.koin.core.context.KoinContext
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

lateinit var koinContext: KoinContext

inline fun <reified T : Any> inject(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
) = lazy { koinContext.get().get<T>(qualifier, parameters) }