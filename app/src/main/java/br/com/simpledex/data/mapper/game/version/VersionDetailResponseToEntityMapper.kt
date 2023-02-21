package br.com.simpledex.data.mapper.game.version

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.game.version.VersionDetailResponse
import br.com.simpledex.data.remote.model.game.version.VersionResponse
import br.com.simpledex.domain.model.game.version.Version
import br.com.simpledex.domain.model.game.version.VersionDetail

class VersionDetailResponseToEntityMapper(
    private val versionResponseToEntityMapper: Mapper<VersionResponse, Version>
) : Mapper<VersionDetailResponse, VersionDetail> {
    override fun map(input: VersionDetailResponse) = input.run {
        VersionDetail(
            rarity = rarity,
            version = version?.let { versionResponseToEntityMapper.map(version) }
        )
    }
}