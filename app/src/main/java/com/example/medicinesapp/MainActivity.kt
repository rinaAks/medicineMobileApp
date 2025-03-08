package com.example.medicinesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicinesapp.ui.theme.MedicinesAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedicinesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        PillsListTracker(pillName = "Витаферр (железо)")
                        PillsListTracker(pillName = "Йодомарин")
                    }
                }
            }
        }
    }
}

@Composable
fun PillsListTracker(pillName: String, modifier: Modifier = Modifier){
    var checked by remember { mutableStateOf(true) }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        //horizontalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(16.dp).background(Color(0xFFCDB4A0),shape = RoundedCornerShape(10.dp))
    ){
        Text(
            text = pillName,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 20.dp)
            // lineHeight = 116.sp,
        )
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun SomeTextPreview() {
    MedicinesAppTheme {
        Column {
            PillsListTracker(pillName = "Витаферр (железо)")
            PillsListTracker(pillName = "Йодомарин")
        }
    }
}