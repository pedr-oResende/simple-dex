package br.com.simpledex.commom.mapper

import br.com.lighttasks.commom.mapper.Mapper
import br.com.lighttasks.commom.mapper.NullableListMapper

class NullableListMapperImpl<I, O>(
    private val mapper: Mapper<I, O>
) : NullableListMapper<I, O> {
    override fun map(input: List<I>?): List<O> {
        return input?.map { mapper.map(it) }.orEmpty()
    }
}