package br.com.simpledex.data.mapper.move

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.commom.mapper.NullableListMapper
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.game.version.VersionGroupDetailsResponse
import br.com.simpledex.data.remote.model.move.MovesResponse
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.game.version.VersionGroupDetails
import br.com.simpledex.domain.model.move.Moves

class MovesResponseToEntityMapper(
    private val moveResponseToEntityMapper: Mapper<ListItemResponse, ListItem>,
    private val versionGroupDetailsResponseToEntityMapper: NullableListMapper<VersionGroupDetailsResponse, VersionGroupDetails>
) : Mapper<MovesResponse, Moves> {
    override fun map(input: MovesResponse) = input.run {
        Moves(
            move = move?.let { moveResponseToEntityMapper.map(move) },
            versionGroupDetails = versionGroupDetailsResponseToEntityMapper.map(versionGroupDetails)
        )
    }

}