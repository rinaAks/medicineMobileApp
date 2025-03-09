package com.example.medicinesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicinesapp.ui.theme.DarkBeige
import com.example.medicinesapp.ui.theme.DarkBrown

import androidx.navigation.NavController
import com.example.medicinesapp.R
import com.example.medicinesapp.ui.theme.LightBeige
import com.example.medicinesapp.ui.theme.LightBrown
import com.example.medicinesapp.ui.theme.MedicinesAppTheme

@Composable
fun MedsScreen(navController: NavController) {
    Column {
        Row(){
            Column(){
                Text(
                    text = "Таблетки",
                    fontSize = 45.sp,
                    modifier = Modifier.padding(start = 24.dp, top = 32.dp),
                    color = LightBrown
                )
            }
            Column(
                modifier = Modifier.padding(start = 50.dp, top = 44.dp)
            ){
                OutlinedButton(onClick = { navController.navigate("ArchiveScreen") }, colors = ButtonDefaults.buttonColors(containerColor = LightBeige, contentColor = LightBrown)) {
                    Text("Архив", color = LightBrown)
                }
            }
        }
        Row {
            PillsListActive(pillName = "Витаферр (железо)", "2", "Во время еды")
        }
        Row {
            PillsListActive(pillName = "Йодомарин", "3", "До еды")
        }
    }
}

@Composable
fun PillsListActive(pillName: String, timesDay: String, timeEating:String, modifier: Modifier = Modifier){
    var checked by remember { mutableStateOf(true) }


    TextButton(onClick = {  }) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(DarkBeige, shape = RoundedCornerShape(10.dp))
                .padding(16.dp)) {
            Column(
                //verticalAlignment = Alignment.CenterVertically,
                //horizontalArrangement = Arrangement.Center,
                //horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = pillName,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = DarkBrown
                    // lineHeight = 116.sp,
                )
                Text(
                    text = timesDay + "р/день",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = DarkBrown
                    // lineHeight = 116.sp,
                )
                Text(
                    text = timeEating,
                    fontSize = 16.sp,
                    color = DarkBrown
                    // lineHeight = 116.sp,
                )

            }
            Box( // для кликабельности заменить на IconButton, но тогда будет круглым
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .shadow(elevation = 5.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.penbutton),
                    contentDescription = "",
                    tint= Color.Unspecified
                )
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun SomeMedsPreview() {
    MedicinesAppTheme {
        Column {
            Row(){
                Column(){
                    Text(
                        text = "Таблетки",
                        fontSize = 45.sp,
                        modifier = Modifier.padding(start = 24.dp, top = 32.dp),
                        color = LightBrown
                    )
                }
                Column(
                    modifier = Modifier.padding(start = 50.dp, top = 44.dp)
                ){
                    OutlinedButton(onClick = {  }, colors = ButtonDefaults.buttonColors(containerColor = LightBeige, contentColor = LightBrown)) {
                        Text("Архив", color = LightBrown)
                    }
                }
            }
            Row {
                PillsListActive(pillName = "Витаферр (железо)", "2", "Во время еды")
            }
            Row {
                PillsListActive(pillName = "Йодомарин", "3", "До еды")
            }
        }

    }
}