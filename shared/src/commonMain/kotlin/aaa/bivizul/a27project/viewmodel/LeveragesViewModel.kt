package aaa.bivizul.a27project.viewmodel

import aaa.bivizul.a27project.levRepository.LeveragesRepository
import aaa.bivizul.a27project.model.Leverages
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class LeveragesViewModel {

    private val repository = LeveragesRepository()

    private val _leverages = MutableSharedFlow<Leverages>()
    val leverages: SharedFlow<Leverages> = _leverages.asSharedFlow()

    suspend fun getLeverages() {
//        viewModelScope.launch {
            val response = repository.getLeverages()
            _leverages.emit(response)
//        }

    }

}