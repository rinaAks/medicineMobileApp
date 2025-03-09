package com.example.medicinesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
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
import com.example.medicinesapp.ui.theme.LightBeige
import com.example.medicinesapp.ui.theme.LightBrown
import com.example.medicinesapp.ui.theme.MedicinesAppTheme
import com.example.medicinesapp.ui.theme.White

@Composable
fun SettingsScreen(navController: NavController) {
    SettingsList()
}

@Composable
fun SettingsList(modifier: Modifier = Modifier){
    MedicinesAppTheme {
        Column(
            modifier = Modifier.padding(start = 16.dp, top = 32.dp)
        ) {
            Row(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    text = "Настройки",
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
                        text = "Уведомления",
                        fontSize = 28.sp,
                        color = LightBrown,
                    )
                }
                Column (modifier = Modifier.padding(start = 32.dp)){
                    SwitchWithIcon()
                    /*

                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Йодомарин") },
                        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = LightBrown),
                        modifier = Modifier.width(150.dp).padding(start = 20.dp).background(color = LightBeige),
                    )*/
                }
            }

            Row(
                modifier = Modifier.padding(bottom = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Column (modifier = Modifier.width(200.dp)) {
                    Text(
                        text = "Уведомления по времени",
                        fontSize = 28.sp,
                        color = LightBrown,
                    )
                }
                Column (modifier = Modifier.padding(start = 32.dp)){
                    SwitchWithIcon()
                }
            }
            FoodTime("Завтрак", "8:00", Modifier)
            FoodTime("Обед", "13:00", Modifier)
            FoodTime("Ужин", "19:00", Modifier)

            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                OutlinedButton(onClick = {  }, colors = ButtonDefaults.buttonColors(containerColor = White, contentColor = LightBrown)) {
                    Text("Экспортировать архив", color = LightBrown)
                }
            }

            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 70.dp)
            ){
                OutlinedButton(onClick = {  }, colors = ButtonDefaults.buttonColors(containerColor = LightBrown, contentColor = LightBrown)) {
                    Text("Сохранить", color = LightBeige)
                }
            }




        }

    }
}

@Composable
fun SwitchWithIcon() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        colors = SwitchDefaults.colors(checkedTrackColor = LightBrown, uncheckedTrackColor = LightBeige, uncheckedBorderColor = LightBrown),
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}

@Composable
fun FoodTime(foodText: String, timeText: String, modifier: Modifier = Modifier){
    Row(
        modifier = Modifier.padding(bottom = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text(
                text =  foodText,
                fontSize = 28.sp,
                color = LightBrown,
            )
        }
        Column {
            var text by remember { mutableStateOf("") }

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(timeText) },
                colors = OutlinedTextFieldDefaults.colors(focusedTextColor = LightBrown),
                modifier = Modifier.width(100.dp).padding(start = 20.dp).background(color = LightBeige),
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun SomeTextPreview() {
    SettingsList()
}