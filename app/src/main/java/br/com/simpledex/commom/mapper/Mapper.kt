package br.com.simpledex.commom.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}