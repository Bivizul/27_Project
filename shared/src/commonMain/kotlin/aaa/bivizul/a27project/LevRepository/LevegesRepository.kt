package aaa.bivizul.a27project.LevRepository

import aaa.bivizul.a27project.model.Leverages
import aaa.bivizul.a27project.network.LevApi
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Leveges
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Levegesres
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class LevegesRepository {

    private val levApi = LevApi()

    suspend fun getLeveges(leveges: Leveges) = levApi.getLevegesres(leveges = leveges)

//    private val _levegesres = MutableSharedFlow<Levegesres>()
//    val levegesres: SharedFlow<Levegesres> = _levegesres.asSharedFlow()
//
//    suspend fun getLeveges(leveges: Leveges) {
//        println("LevegesRepository")
//        val response = levApi.getLevegesres(leveges = leveges)
//        println("LevegesRepository $response")
//        _levegesres.emit(response)
//    }

}