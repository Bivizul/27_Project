package aaa.bivizul.a27project.levRepository

import aaa.bivizul.a27project.network.LevApi

class LeveragesRepository {

    private val levApi = LevApi()

    suspend fun getLeverages() = levApi.getLeverages()

    /*private val _leverages = MutableSharedFlow<Leverages>()
    val leverages: SharedFlow<Leverages> = _leverages.asSharedFlow()

    suspend fun getContics() {
        val response = levApi.getLeverages()
        _leverages.emit(response)
    }*/

}