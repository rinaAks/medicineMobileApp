package com.example.medicinesapp

import androidx.lifecycle.ViewModel

class MedEditScreenViewModel:ViewModel() {
    private val medRepository = MedRepository();

    fun fetchMed() : Med{
        val med = medRepository.loadMed()
        return med
    }
}


/*
// здесь не будет Loading,
// но теоретически может быть состояние Fail какой-нибудь?
// хотя если репозиторий пустой, то это наверное не здесь обрабатывается
sealed class MedScreenState{
    data object Loading : MedScreenState()
    data class Success(val currentMed:Med) : MedScreenState()
}
*/