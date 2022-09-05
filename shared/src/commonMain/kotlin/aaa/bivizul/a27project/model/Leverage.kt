package aaa.bivizul.a27project.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Leverage(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
)