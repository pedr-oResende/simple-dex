package br.com.simpledex.data.mapper.game.other

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.game.other.HeldItemResponse
import br.com.simpledex.domain.model.game.other.HeldItem

class HeldItemResponseToEntityMapper : Mapper<HeldItemResponse, HeldItem> {
    override fun map(input: HeldItemResponse) = input.run {
        HeldItem(
            name = name,
            url = url
        )
    }
}