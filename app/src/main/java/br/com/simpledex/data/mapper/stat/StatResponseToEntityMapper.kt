package br.com.simpledex.data.mapper.stat

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.stat.StatResponse
import br.com.simpledex.domain.model.stat.Stat

class StatResponseToEntityMapper : Mapper<StatResponse, Stat> {
    override fun map(input: StatResponse) = input.run {
        Stat(
            name = name,
            url = url
        )
    }
}