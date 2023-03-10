package br.com.simpledex.commom.extension

inline fun <reified T : Enum<T>> enumValueOf(value: String, default: T): T {
    return try {
        enumValueOf(value)
    } catch (e: IllegalArgumentException) {
        default
    }
}