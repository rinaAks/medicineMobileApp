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
    var name: String,      // Название препарата
    var type: String,      // Вид
    var dailyIntake: Int,  // Кол-во приёмов в день
    var duration: Int,     // Продолжительность приёма
    var dose: Double,      // Доза
    var doseUnit: String,  // Мера дозы
    var intakeTiming: Int, // 0 - До, 1 - Во время, 2 - После
    var notes: String      // Примечания
)
