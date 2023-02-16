package br.com.simpledex.data.mapper.stat

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.mapper.type.TypesResponseToEntityMapper
import br.com.simpledex.data.model.stat.StatResponse
import br.com.simpledex.data.model.stat.StatsResponse
import br.com.simpledex.domain.model.stat.Stat
import br.com.simpledex.domain.model.stat.Stats

class StatsResponseToEntityMapper(
    private val statResponseToEntityMapper: Mapper<StatResponse, Stat>
) : Mapper<StatsResponse, Stats> {
    override fun map(input: StatsResponse) = input.run {
        Stats(
            stat = if (stat != null) statResponseToEntityMapper.map(stat) else null,
            baseStat = baseStat,
            effort = effort
        )
    }
}