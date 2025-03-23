package com.example.medicinesapp

import kotlinx.coroutines.delay

class MedRepository {
    private var meds = listOf(
        Med(
            name = "Йодомарин",
            type = "таблетки",
            dailyIntake = 3,
            duration = 90,
            dose = 1.0,
            doseUnit = "таблетка",
            intakeTiming = 0,
            notes = ""
        ),
        Med(
            name = "Витаферр (железо)",
            type = "таблетки",
            dailyIntake = 1,
            duration = 90,
            dose = 1.0,
            doseUnit = "таблетка",
            intakeTiming = 2,
            notes = ""
        ),
        Med(
            name = "Аскорбинка",
            type = "порошок",
            dailyIntake = 1,
            duration = 14,
            dose = 0.5,
            doseUnit = "пачка",
            intakeTiming = 1,
            notes = "растворять в воде"
        )
    )

    suspend fun loadMed() : Med{
        /*
        if (meds.isEmpty()){
            return null
        }
        */
        delay(1000)
        return meds.random()
    }

    fun addMed(med:Med){
        meds += med
    }

    fun changeMed(med: Med, newMed: Med){
        med.name = newMed.name
        med.type = newMed.type
        med.dailyIntake = newMed.dailyIntake
        med.duration = newMed.duration
        med.dose = newMed.dose
        med.doseUnit = newMed.doseUnit
        med.intakeTiming = newMed.intakeTiming
        med.notes = newMed.notes
    }
}