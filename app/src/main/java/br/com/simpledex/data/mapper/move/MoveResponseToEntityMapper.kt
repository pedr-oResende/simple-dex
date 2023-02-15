package br.com.simpledex.data.mapper.move

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.model.move.MoveResponse
import br.com.simpledex.data.model.move.MovesResponse
import br.com.simpledex.domain.model.move.Move
import br.com.simpledex.domain.model.move.Moves

class MoveResponseToEntityMapper : Mapper<MoveResponse, Move> {
    override fun map(input: MoveResponse) = input.run {
        Move(
            name = name,
            url = url
        )
    }

}