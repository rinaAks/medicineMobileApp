package com.example.medicinesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
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
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medicinesapp.ui.theme.DarkBeige
import com.example.medicinesapp.ui.theme.DarkBrown
import com.example.medicinesapp.ui.theme.LightBeige




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
                        Main()
                    }
                }
            }
        }
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()
    Column(Modifier.padding(8.dp)) {
        NavBar(navController = navController)
        NavHost(navController, startDestination = NavRoutes.Home.route) {
            composable(NavRoutes.Home.route) { Home() }
            composable(NavRoutes.Contacts.route) { Contacts()  }
            composable(NavRoutes.About.route) { About() }
        }
    }
}
@Composable
fun NavBar(navController: NavController){
    Row(
        Modifier.fillMaxWidth().padding(bottom = 8.dp)){
        Text("Home",
            Modifier
                .weight(0.33f)
                .clickable { navController.navigate(NavRoutes.Home.route) }, fontSize = 22.sp, color= Color(0xFF6650a4))
        Text("Contacts",
            Modifier
                .weight(0.33f)
                .clickable { navController.navigate(NavRoutes.Contacts.route) }, fontSize = 22.sp, color= Color(0xFF6650a4))
        Text("About",
            Modifier
                .weight(0.33f)
                .clickable { navController.navigate(NavRoutes.About.route) }, fontSize = 22.sp, color= Color(0xFF6650a4))
    }
}

@Composable
fun Home(){
    Text("Home Page", fontSize = 30.sp)
}
@Composable
fun Contacts(){
    Text("Contact Page", fontSize = 30.sp)
}
@Composable
fun About(){
    Text("About Page", fontSize = 30.sp)
}

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Contacts : NavRoutes("contact")
    object About : NavRoutes("about")
}

@Composable
fun PillsListTracker(pillName: String, modifier: Modifier = Modifier){
    var checked by remember { mutableStateOf(true) }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        //horizontalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(16.dp).background(DarkBeige,shape = RoundedCornerShape(10.dp))
    ){
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

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun SomeTextPreview() {
    MedicinesAppTheme {
        Column {
            PillsListTracker(pillName = "Витаферр (железо)")
            PillsListTracker(pillName = "Йодомарин")
            Main()
        }
    }
}