package aaa.bivizul.a27project.model

@kotlinx.serialization.Serializable
data class Leverages(
    val intro: String,
    val leverage: List<Leverage>,
    val titleLeverages: String
)