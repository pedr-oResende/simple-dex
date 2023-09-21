package br.com.simpledex.data.mapper.stat

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.stat.StatsResponse
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.stat.Stats

class StatsResponseToEntityMapper(
    private val statResponseToEntityMapper: Mapper<ListItemResponse, ListItem>
) : Mapper<StatsResponse, Stats> {
    override fun map(input: StatsResponse) = input.run {
        Stats(
            stat = stat?.let { statResponseToEntityMapper.map(stat) },
            baseStat = baseStat,
            effort = effort
        )
    }
}