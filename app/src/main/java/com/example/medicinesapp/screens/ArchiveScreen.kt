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
import androidx.compose.material3.IconButton
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
fun ArchiveScreen(navController: NavController) {
    Column {
        Row(){
            Column(){
                Text(
                    text = "Архив",
                    fontSize = 45.sp,
                    modifier = Modifier.padding(start = 24.dp, top = 32.dp),
                    color = LightBrown
                )
            }
        }
        Row {
            PillsListArchive(pillName = "Арбидол", "12.02.2025-26.02.2025", navController)
        }
        Row {
            PillsListArchive(pillName = "Тотема (железо)", "05.09.2024-05.12.2024", navController)
        }
    }
}

@Composable
fun PillsListArchive(pillName: String, dateText: String, navController: NavController, modifier: Modifier = Modifier){
    var checked by remember { mutableStateOf(true) }


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
            )
            Text(
                text = dateText,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 16.dp),
                color = DarkBrown
            )

        }
        IconButton( // чтобы квадратные были края, на Box, но тогда кнопка не работает
            onClick = {  },
            modifier = Modifier
                .align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.deleteicon),
                contentDescription = "",
                tint= Color.Unspecified
            )
        }
    }

}
