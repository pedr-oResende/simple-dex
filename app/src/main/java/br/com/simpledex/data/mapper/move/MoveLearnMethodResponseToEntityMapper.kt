package br.com.simpledex.data.mapper.move

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.move.MoveLearnMethodResponse
import br.com.simpledex.domain.model.move.MoveLearnMethod

class MoveLearnMethodResponseToEntityMapper : Mapper<MoveLearnMethodResponse, MoveLearnMethod> {
    override fun map(input: MoveLearnMethodResponse) = input.run {
        MoveLearnMethod(
            name = name,
            url = url
        )
    }

}