package aaa.bivizul.a27project.viewmodel

import aaa.bivizul.a27project.LevRepository.LevegesRepository
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Leveges
import com.bivizul.whenshouldyouplacebetsinsportsbetting.entity.Levegesres
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class LevegesViewModel {

    private val repository = LevegesRepository()

    private val _levegesres = MutableSharedFlow<Levegesres>()
    val levegesres: SharedFlow<Levegesres> = _levegesres.asSharedFlow()

    suspend fun getLeveges(leveges: Leveges) {
//        viewModelScope.launch {
            val response = repository.getLeveges(leveges = leveges)
            _levegesres.emit(response)
//        }

    }

}