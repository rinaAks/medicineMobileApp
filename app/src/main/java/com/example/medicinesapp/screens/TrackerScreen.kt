package com.example.medicinesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.example.medicinesapp.ui.theme.DarkBeige
import com.example.medicinesapp.ui.theme.DarkBrown

import androidx.navigation.NavController
import com.example.medicinesapp.ui.theme.LightBeige
import com.example.medicinesapp.ui.theme.LightBrown
import com.example.medicinesapp.ui.theme.MedicinesAppTheme

@Composable
fun TrackerScreen(navController: NavController) {
    Column {
        CalendarWeek()
        PillsListTracker(pillName = "Витаферр (железо)", navController)
        PillsListTracker(pillName = "Йодомарин", navController)
    }
}

@Composable
fun CalendarWeek(modifier: Modifier = Modifier){

    Column (
        modifier = Modifier
            //.fillMaxWidth()
            //.padding(16.dp)
            //.background(DarkBeige, shape = RoundedCornerShape(10.dp))

    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, top = 50.dp, end = 32.dp, bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            Text(text = "S")
            Text(text = "M")
            Text(text = "T")
            Text(text = "W")
            Text(text = "T")
            Text(text = "F")
            Text(text = "S")
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ){
            Text(text = "3")
            Text(text = "4")
            Text(text = "5")
            Text(text = "6")
            Column {
                Text(
                    text = "7",
                    color = LightBeige,
                    modifier = Modifier.background(LightBrown, shape = CircleShape)
                )
            }
            Text(text = "8")
            Text(text = "9")
        }
    }
}

@Composable
fun PillsListTracker(pillName: String, navController: NavController, modifier: Modifier = Modifier){
    var checked by remember { mutableStateOf(true) }


    TextButton(onClick = { navController.navigate("MedEditScreen") }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            //horizontalArrangement = Arrangement.Center,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(DarkBeige, shape = RoundedCornerShape(10.dp))
        ) {
            Text(
                text = pillName,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 20.dp),
                color = DarkBrown
                // lineHeight = 116.sp,
            )

            Checkbox(
                checked = checked,
                onCheckedChange = { checked = it }
                /*
    colors = CheckboxColors(
        DarkBeige,
        LightBeige,
        DarkBeige,
        LightBeige,
        LightBeige,
        LightBeige,
        LightBeige,
        DarkBeige,
        LightBeige,
        LightBeige,
        LightBeige
    )
    */

            )
        }
    }
}

/*
@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun SomeTextPreview() {
    MedicinesAppTheme {
        Column {
            CalendarWeek()
            PillsListTracker(pillName = "Витаферр (железо)")
            PillsListTracker(pillName = "Йодомарин")
        }
    }
}*/