package br.com.simpledex.data.mapper.game.version

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.commom.ListItemResponse
import br.com.simpledex.data.remote.model.game.version.VersionDetailResponse
import br.com.simpledex.domain.model.commom.ListItem
import br.com.simpledex.domain.model.game.version.VersionDetail

class VersionDetailResponseToEntityMapper(
    private val versionResponseToEntityMapper: Mapper<ListItemResponse, ListItem>
) : Mapper<VersionDetailResponse, VersionDetail> {
    override fun map(input: VersionDetailResponse) = input.run {
        VersionDetail(
            rarity = rarity,
            version = version?.let { versionResponseToEntityMapper.map(version) }
        )
    }
}