package aaa.bivizul.a27project.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Leverages(
    @SerialName("intro") val intro: String,
    @SerialName("leverage") val leverage: List<Leverage>,
    @SerialName("titleLeverages") val titleLeverages: String,
)