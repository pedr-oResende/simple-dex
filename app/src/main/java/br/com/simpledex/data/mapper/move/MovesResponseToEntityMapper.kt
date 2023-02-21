package br.com.simpledex.data.mapper.move

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.commom.mapper.NullableListMapper
import br.com.simpledex.data.remote.model.game.version.VersionGroupDetailsResponse
import br.com.simpledex.data.remote.model.move.MoveResponse
import br.com.simpledex.data.remote.model.move.MovesResponse
import br.com.simpledex.domain.model.game.version.VersionGroupDetails
import br.com.simpledex.domain.model.move.Move
import br.com.simpledex.domain.model.move.Moves

class MovesResponseToEntityMapper(
    private val moveResponseToEntityMapper: Mapper<MoveResponse, Move>,
    private val versionGroupDetailsResponseToEntityMapper: NullableListMapper<VersionGroupDetailsResponse, VersionGroupDetails>
) : Mapper<MovesResponse, Moves> {
    override fun map(input: MovesResponse) = input.run {
        Moves(
            move = if (move != null) moveResponseToEntityMapper.map(move) else null,
            versionGroupDetails = versionGroupDetailsResponseToEntityMapper.map(versionGroupDetails)
        )
    }

}