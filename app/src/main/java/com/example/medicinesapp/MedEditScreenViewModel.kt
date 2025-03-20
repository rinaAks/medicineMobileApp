package com.example.medicinesapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MedEditScreenViewModel:ViewModel() {
    var uiState by mutableStateOf<MedScreenState>(MedScreenState.Loading)
        private set

    private val medRepository = MedRepository()

    fun fetchMed() {
        // это если state не использовать
        // val med = medRepository.loadMed()
        // return med
        // и тогда ещё fun fetchMed() : Med {}

        // проблема с бесконечным обновлением
        uiState = MedScreenState.Loading
        val med = medRepository.loadMed()
        uiState = MedScreenState.Success(med)

        /*
        if (med == null){
            uiState = MedScreenState.Error
        }
        else {
            uiState = MedScreenState.Success(med)
        }
        */
    }

    fun addMed(med:Med) {
        medRepository.addMed(med)
    }
}



// здесь не будет Loading,
// но теоретически может быть состояние Fail какой-нибудь?
// хотя если репозиторий пустой, то это наверное не здесь обрабатывается
sealed class MedScreenState{
    data object Loading : MedScreenState()
    // data object Error : MedScreenState()
    data class Success(val currentMed:Med) : MedScreenState()
}
