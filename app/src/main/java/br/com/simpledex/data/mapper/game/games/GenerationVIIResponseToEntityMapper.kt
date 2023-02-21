package br.com.simpledex.data.mapper.game.games

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.game.games.GenerationVIIResponse
import br.com.simpledex.data.remote.model.game.games.UltraSunUltraMoonResponse
import br.com.simpledex.data.remote.model.icons.IconsResponse
import br.com.simpledex.domain.model.game.games.GenerationVII
import br.com.simpledex.domain.model.game.games.UltraSunUltraMoon
import br.com.simpledex.domain.model.icons.Icons

class GenerationVIIResponseToEntityMapper(
    private val ultraSunUltraMoonResponseToEntityMapper: Mapper<UltraSunUltraMoonResponse, UltraSunUltraMoon>,
    private val iconsResponseToEntityMapper: Mapper<IconsResponse, Icons>,
) : Mapper<GenerationVIIResponse, GenerationVII> {
    override fun map(input: GenerationVIIResponse) = input.run {
        GenerationVII(
            icons = if (icons != null) iconsResponseToEntityMapper.map(icons) else null,
            ultraSunUltraMoon = if (ultraSunUltraMoon != null)
                ultraSunUltraMoonResponseToEntityMapper.map(ultraSunUltraMoon) else null
        )
    }
}