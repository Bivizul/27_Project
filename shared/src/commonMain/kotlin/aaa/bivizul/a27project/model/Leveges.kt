package com.bivizul.whenshouldyouplacebetsinsportsbetting.entity

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Leveges(
    @SerialName("levegesmm") val levegesmm: String,
    @SerialName("levegessim") val levegessim: String,
    @SerialName("levegesid") val levegesid: String,
    @SerialName("levegesl") val levegesl: String,
    @SerialName("levegest") val levegest: String,
)
