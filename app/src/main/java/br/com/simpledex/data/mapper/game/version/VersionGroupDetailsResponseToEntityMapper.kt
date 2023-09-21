package br.com.simpledex.data.mapper.game.version

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.game.version.VersionGroupDetailsResponse
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.game.version.VersionGroupDetails

class VersionGroupDetailsResponseToEntityMapper(
    private val listItemResponseToListItemMapper: Mapper<ListItemResponse, ListItem>
) : Mapper<VersionGroupDetailsResponse, VersionGroupDetails> {
    override fun map(input: VersionGroupDetailsResponse) = input.run {
        VersionGroupDetails(
            levelLearnedAt = levelLearnedAt,
            moveLearnMethod = moveLearnMethod?.let {
                listItemResponseToListItemMapper.map(moveLearnMethod)
            },
            versionGroup = versionGroup?.let {
                listItemResponseToListItemMapper.map(versionGroup)
            }
        )
    }
}