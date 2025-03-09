package com.example.medicinesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.medicinesapp.Navigation
import com.example.medicinesapp.ui.theme.LightBeige
import com.example.medicinesapp.ui.theme.LightBrown
import com.example.medicinesapp.ui.theme.MedicinesAppTheme
import com.example.medicinesapp.ui.theme.White

@Composable
fun MedEditScreen(navController: NavController) {
    EditComponents()
}

@Composable
fun EditComponents(){
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
                    var text by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Йодомарин") },
                        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = LightBrown),
                        modifier = Modifier.width(150.dp).padding(start = 20.dp).background(color = LightBeige),
                    )
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
                    var text by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("таблетки") },
                        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = LightBrown),
                        modifier = Modifier.width(150.dp).padding(start = 20.dp)
                            .background(color = LightBeige),
                    )
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
                    var text by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("3") },
                        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = LightBrown),
                        modifier = Modifier.width(70.dp).padding(start = 20.dp)
                            .background(color = LightBeige),
                    )
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
                    var text by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("3") },
                        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = LightBrown),
                        modifier = Modifier.width(70.dp).padding(start = 20.dp)
                            .background(color = LightBeige),
                    )
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
                    var text by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("1") },
                        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = LightBrown),
                        modifier = Modifier.width(70.dp).padding(start = 20.dp)
                            .background(color = LightBeige),
                    )
                }
                Column {
                    var text by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("таблетка") },
                        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = LightBrown),
                        modifier = Modifier.width(150.dp).padding(start = 20.dp)
                            .background(color = LightBeige),
                    )
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
                    var text by remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("") },
                        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = LightBrown),
                        modifier = Modifier.width(70.dp).padding(start = 20.dp)
                            .background(color = LightBeige),
                    )
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



@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun ditMedsPreview() {
    EditComponents()
}