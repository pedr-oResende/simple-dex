package br.com.simpledex.commom.extension

infix fun <T> T?.ifNull(other: T): T = this ?: other