package br.com.simpledex.data.mapper.game.version

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.game.version.VersionResponse
import br.com.simpledex.domain.model.game.version.Version

class VersionResponseToEntityMapper : Mapper<VersionResponse, Version> {
    override fun map(input: VersionResponse) = input.run {
        Version(
            name = name,
            url = url
        )
    }

}