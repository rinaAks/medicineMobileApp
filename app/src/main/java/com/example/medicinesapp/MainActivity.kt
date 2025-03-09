package com.example.medicinesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.medicinesapp.ui.theme.MedicinesAppTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medicinesapp.ui.theme.LightBeige

import com.example.medicinesapp.screens.TrackerScreen
import androidx.compose.ui.res.vectorResource
import com.example.medicinesapp.screens.ArchiveScreen
import com.example.medicinesapp.screens.MedEditScreen
import com.example.medicinesapp.screens.MedsScreen
import com.example.medicinesapp.screens.SettingsScreen

data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedicinesAppTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    val items = listOf(
        BottomNavItem(
            title = "Трекер",
            selectedIcon = ImageVector.vectorResource(R.drawable.tracker_selected),
            unselectedIcon = ImageVector.vectorResource(R.drawable.tracker_unselected)
        ),
        BottomNavItem(
            title = "Таблетки",
            selectedIcon = ImageVector.vectorResource(R.drawable.meds_selected),
            unselectedIcon = ImageVector.vectorResource(R.drawable.meds_unselected)
        ),
        BottomNavItem(
            title = "Настройки",
            selectedIcon = ImageVector.vectorResource(R.drawable.sett_selected),
            unselectedIcon = ImageVector.vectorResource(R.drawable.sett_unselected)
        ),

        )
    var selectedItemIndex by rememberSaveable{
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = LightBeige
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar{
                    items.forEachIndexed{index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                if(item.title == "Трекер") {
                                    navController.navigate("trackerScreen")
                                }
                                if(item.title == "Таблетки") {
                                    navController.navigate("medsScreen")
                                }
                                if(item.title == "Настройки") {
                                    navController.navigate("settScreen")
                                }

                            },
                            label = {
                                Text(text = item.title)
                            },
                            icon = {
                                Icon(
                                    imageVector = if(index == selectedItemIndex){
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title,
                                    tint= Color.Unspecified
                                )

                            }
                        )
                    }
                }
            }
        ){innerPadding ->
            Box(modifier = Modifier.padding(innerPadding))
        }
    }

    NavHost(navController, startDestination = "trackerScreen") {
        composable("trackerScreen") { TrackerScreen(navController) }
        composable("medsScreen") { MedsScreen(navController) }
        composable("medEditScreen") { MedEditScreen(navController) }
        composable("archiveScreen") { ArchiveScreen(navController) }
        composable("settScreen") { SettingsScreen(navController) }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun SomeTextPreview() {
    MedicinesAppTheme {
        Navigation()
    }
}
