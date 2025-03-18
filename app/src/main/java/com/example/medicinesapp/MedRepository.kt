package com.example.medicinesapp

class MedRepository {
    private val meds = listOf(
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
}