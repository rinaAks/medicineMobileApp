package com.example.medicinesapp

import androidx.annotation.StringRes

/*
1. Название препарата - String
2. Вид - String
3. Кол-во приёмов в день - Int
4. Продолжительность приёма - Int
5. Доза - Double
6. Мера дозы - String
7. До / во время / после - Int, переключатель там
8. Примечания - String
 */

data class Med(
    val name: String,      // Название препарата
    val type: String,      // Вид
    val dailyIntake: Int,  // Кол-во приёмов в день
    val duration: Int,     // Продолжительность приёма
    val dose: Double,      // Доза
    val doseUnit: String,  // Мера дозы
    val intakeTiming: Int, // 0 - До, 1 - Во время, 2 - После
    val notes: String      // Примечания
)
