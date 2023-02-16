package br.com.simpledex.data.mapper.game.version

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.game.version.VersionGroupResponse
import br.com.simpledex.domain.model.game.version.VersionGroup

class VersionGroupResponseToEntityMapper : Mapper<VersionGroupResponse, VersionGroup> {
    override fun map(input: VersionGroupResponse) = input.run {
        VersionGroup(
            name = name,
            url = url
        )
    }
}