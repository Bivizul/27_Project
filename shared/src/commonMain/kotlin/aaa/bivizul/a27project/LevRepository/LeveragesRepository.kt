package aaa.bivizul.a27project.LevRepository

import aaa.bivizul.a27project.model.Leverages
import aaa.bivizul.a27project.network.LevApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

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