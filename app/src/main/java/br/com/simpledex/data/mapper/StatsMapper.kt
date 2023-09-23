package br.com.simpledex.data.mapper

import br.com.simpledex.data.remote.model.stat.StatsResponse
import br.com.simpledex.domain.model.stat.Stats

fun StatsResponse.toEntity() = Stats(
    stat = stat?.toEntity(),
    baseStat = baseStat,
    effort = effort
)