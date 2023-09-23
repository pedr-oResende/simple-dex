package br.com.simpledex.commom.extension

infix fun <T> T?.ifNull(other: T): T = this ?: other

fun Int?.orZero(): Int = this ifNull 0

fun Float?.orZero(): Float = this ifNull 0f

fun Double?.orZero(): Double = this ifNull 0.0