package br.com.simpledex.data.mapper.stat

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.mapper.type.TypesResponseToEntityMapper
import br.com.simpledex.data.remote.model.stat.StatResponse
import br.com.simpledex.data.remote.model.stat.StatsResponse
import br.com.simpledex.domain.model.stat.Stat
import br.com.simpledex.domain.model.stat.Stats

class StatsResponseToEntityMapper(
    private val statResponseToEntityMapper: Mapper<br.com.simpledex.data.remote.model.stat.StatResponse, Stat>
) : Mapper<br.com.simpledex.data.remote.model.stat.StatsResponse, Stats> {
    override fun map(input: br.com.simpledex.data.remote.model.stat.StatsResponse) = input.run {
        Stats(
            stat = if (stat != null) statResponseToEntityMapper.map(stat) else null,
            baseStat = baseStat,
            effort = effort
        )
    }
}