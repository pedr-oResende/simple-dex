package br.com.simpledex.data.mapper.game.other

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.commom.mapper.NullableListMapper
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.game.other.HeldItemsResponse
import br.com.simpledex.data.remote.model.game.version.VersionDetailResponse
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.game.other.HeldItems
import br.com.simpledex.domain.model.game.version.VersionDetail

class HeldItemsResponseToEntityMapper(
    private val heldItemResponseToEntityMapper: Mapper<ListItemResponse, ListItem>,
    private val versionDetailsResponseToEntityMapper: NullableListMapper<VersionDetailResponse, VersionDetail>,
) : Mapper<HeldItemsResponse, HeldItems> {
    override fun map(input: HeldItemsResponse) = input.run {
        HeldItems(
            item = item?.let { heldItemResponseToEntityMapper.map(item) },
            versionDetails = versionDetailsResponseToEntityMapper.map(versionDetails)
        )
    }
}