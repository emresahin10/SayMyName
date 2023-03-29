package com.emresahin.saymyname.common.extension

inline fun <R> tryOrNull(block: () -> R): R? {
    return try {
        block()
    } catch (e: Throwable) {
        null
    }
}

inline fun <T, R> T.tryOrNull(block: T.() -> R): R? {
    return try {
        block()
    } catch (e: Throwable) {
        null
    }
}

inline fun <R> tryOr(fallback: R, block: () -> R): R {
    return try {
        block()
    } catch (e: Throwable) {
        fallback
    }
}
