package aaa.bivizul.a27project.levRepository

import aaa.bivizul.a27project.network.LevApi
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Leveges

class LevegesRepository {

    private val levApi = LevApi()

    suspend fun getLeveges(leveges: Leveges) = levApi.getLevegesres(leveges = leveges)

}