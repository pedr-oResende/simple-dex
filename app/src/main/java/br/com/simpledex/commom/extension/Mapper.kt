package br.com.simpledex.commom.extension

inline fun <T, R> Iterable<T>?.nullableMap(transform: (T) -> R): List<R> {
    return this?.map(transform) ?: emptyList()
}