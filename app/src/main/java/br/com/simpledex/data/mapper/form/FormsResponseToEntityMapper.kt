package br.com.simpledex.data.mapper.form

import br.com.simpledex.commom.mapper.Mapper
import br.com.simpledex.data.remote.model.form.FormsResponse
import br.com.simpledex.domain.model.form.Forms

class FormsResponseToEntityMapper : Mapper<FormsResponse, Forms> {
    override fun map(input: FormsResponse) = input.run {
        Forms(
            name = name,
            url = url
        )
    }
}