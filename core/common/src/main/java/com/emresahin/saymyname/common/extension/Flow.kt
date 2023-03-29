package com.emresahin.saymyname.common.extension

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update

fun <T1, T2, R> combine(
    flow: Flow<T1>,
    flow2: Flow<T2>,
    transform: suspend (T1, T2) -> R
): Flow<R> = combine(listOf(flow, flow2)) { args ->
    @Suppress("UNCHECKED_CAST")
    transform(
        args[0] as T1,
        args[1] as T2,
    )
}

fun <T1, T2, T3, T4, T5, R> combine(
    flow: Flow<T1>,
    flow2: Flow<T2>,
    flow3: Flow<T3>,
    flow4: Flow<T4>,
    flow5: Flow<T5>,
    transform: suspend (T1, T2, T3, T4, T5) -> R
): Flow<R> = combine(listOf(flow, flow2, flow3, flow4, flow5)) { args ->
    @Suppress("UNCHECKED_CAST")
    transform(
        args[0] as T1,
        args[1] as T2,
        args[2] as T3,
        args[3] as T4,
        args[4] as T5,
    )
}

@Deprecated(
    "Deprecated in favor of update extension in library",
    ReplaceWith("update { it.updater() }", "kotlinx.coroutines.flow.update"),
)
fun <T> MutableStateFlow<T>.updateValue(updater: T.() -> T) {
    update { it.updater() }
}
