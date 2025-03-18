package com.example.medicinesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.medicinesapp.Med
import com.example.medicinesapp.MedEditScreenViewModel
import com.example.medicinesapp.ui.theme.LightBeige
import com.example.medicinesapp.ui.theme.LightBrown
import com.example.medicinesapp.ui.theme.MedicinesAppTheme
import com.example.medicinesapp.ui.theme.White
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import com.example.medicinesapp.ui.theme.DarkBeige
import com.example.medicinesapp.ui.theme.DarkBrown

private val medEditScreenViewModel = MedEditScreenViewModel()

@Composable
fun MedEditScreen(navController: NavController) {
    val med = medEditScreenViewModel.fetchMed()
    EditComponents(med)
}

@Composable
fun EditComponents(med : Med){
    MedicinesAppTheme {
        Column(
            modifier = Modifier.padding(start = 16.dp, top = 32.dp)
        ){
            Row(
                modifier = Modifier.padding(bottom = 16.dp)
            ){
                Text(
                    text = "Редактирование",
                    fontSize = 45.sp,
                    color = LightBrown
                )
            }
            Row(
                modifier = Modifier.padding(bottom = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Column {
                    Text(
                        text = "Название",
                        fontSize = 28.sp,
                        color = LightBrown,
                    )
                }
                Column {
                    PlaceTextField(modifier = Modifier, labelText = med.name)
                }
            }
            Row(
                modifier = Modifier.padding(bottom = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Вид",
                        fontSize = 28.sp,
                        color = LightBrown,
                    )
                }
                Column {
                    PlaceTextField(modifier = Modifier, labelText = med.type)
                }
            }
            Row(
                modifier = Modifier.padding(bottom = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Приёмов в день",
                        fontSize = 28.sp,
                        color = LightBrown,
                    )
                }
                Column {
                    PlaceTextField(modifier = Modifier, labelText = med.dailyIntake.toString())
                }
            }

            Row(
                modifier = Modifier.padding(bottom = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column (
                    modifier = Modifier.width(280.dp)
                )
                {
                    Text(
                        text = "Продолжительность приёма",
                        fontSize = 28.sp,
                        color = LightBrown,

                    )
                }
                Column {
                    PlaceTextField(modifier = Modifier, labelText = med.duration.toString())
                }
            }

            Row(
                modifier = Modifier.padding(bottom = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Доза",
                        fontSize = 28.sp,
                        color = LightBrown,
                        )
                }
                Column {
                    PlaceTextField(modifier = Modifier, labelText = med.dose.toString())
                }
                Column {
                    PlaceTextField(modifier = Modifier, labelText = med.doseUnit)
                }
            }

            Row(
                modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column {
                    SingleChoiceSegmentedButton()
                }
            }

            Row(
                modifier = Modifier.padding(bottom = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Примечания",
                        fontSize = 28.sp,
                        color = LightBrown,
                    )
                }
                Column {
                    PlaceTextField(modifier = Modifier, labelText = med.notes)
                }
            }

            Row(
                modifier = Modifier.padding(bottom = 32.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,

            ) {
                Column (
                    modifier = Modifier.padding(end = 16.dp)
                ){
                    OutlinedButton(onClick = {  }, colors = ButtonDefaults.buttonColors(containerColor = White, contentColor = LightBrown)) {
                        Text("Отменить", color = LightBrown)
                    }
                }
                Column {
                    OutlinedButton(onClick = {  }, colors = ButtonDefaults.buttonColors(containerColor = LightBrown, contentColor = LightBrown)) {
                        Text("Сохранить", color = LightBeige)
                    }
                }
            }
        }

    }

}

@Composable
fun PlaceTextField(modifier: Modifier, labelText: String){
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(labelText) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = LightBrown,
            unfocusedTextColor = LightBrown,
            disabledTextColor = LightBrown
        ),
        modifier = Modifier.widthIn(min = 50.dp, max = 250.dp).padding(start = 20.dp, end = 20.dp)
            .background(color = LightBeige),
        singleLine = true
    )
}

@Composable
fun SingleChoiceSegmentedButton(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("До ", "Во время", "После")

    SingleChoiceSegmentedButtonRow {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = DarkBeige,
                    activeContentColor = DarkBrown,
                    activeBorderColor = LightBrown,
                    inactiveContainerColor = LightBeige,
                    inactiveContentColor = DarkBrown
                ),
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = { selectedIndex = index },
                selected = index == selectedIndex,
                label = { Text(label) }
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun editMedsPreview() {
    SingleChoiceSegmentedButton()
}