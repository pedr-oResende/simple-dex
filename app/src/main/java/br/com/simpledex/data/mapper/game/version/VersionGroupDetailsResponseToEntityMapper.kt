package br.com.simpledex.data.mapper.game.version

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.mapper.move.MovesResponseToEntityMapper
import br.com.simpledex.data.model.game.version.VersionGroupDetailsResponse
import br.com.simpledex.data.model.game.version.VersionGroupResponse
import br.com.simpledex.data.model.move.MoveLearnMethodResponse
import br.com.simpledex.domain.model.game.version.VersionGroup
import br.com.simpledex.domain.model.game.version.VersionGroupDetails
import br.com.simpledex.domain.model.move.MoveLearnMethod

class VersionGroupDetailsResponseToEntityMapper(
    private val versionGroupResponseToEntityMapper: Mapper<VersionGroupResponse, VersionGroup>,
    private val moveLearnMethodResponseToEntityMapper: Mapper<MoveLearnMethodResponse, MoveLearnMethod>
) :
    Mapper<VersionGroupDetailsResponse, VersionGroupDetails> {
    override fun map(input: VersionGroupDetailsResponse) = input.run {
        VersionGroupDetails(
            levelLearnedAt = levelLearnedAt,
            moveLearnMethod = if (moveLearnMethod != null)
                moveLearnMethodResponseToEntityMapper.map(moveLearnMethod) else null,
            versionGroup = if (versionGroup != null)
                versionGroupResponseToEntityMapper.map(versionGroup) else null
        )
    }
}