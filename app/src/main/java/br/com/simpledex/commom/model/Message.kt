package br.com.simpledex.commom.model

import kotlinx.serialization.Serializable

@Serializable
data class Message(
    val message: String,
    val error: MessageError,
    val success: Boolean
)
