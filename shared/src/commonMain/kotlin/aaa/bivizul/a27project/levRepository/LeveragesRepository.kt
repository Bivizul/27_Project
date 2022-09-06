package aaa.bivizul.a27project.levRepository

import aaa.bivizul.a27project.network.LevApi

class LeveragesRepository {

    private val levApi = LevApi()

    suspend fun getLeverages() = levApi.getLeverages()

}