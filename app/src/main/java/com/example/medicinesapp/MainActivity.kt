package com.example.medicinesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medicinesapp.screens.PillsListTracker
import com.example.medicinesapp.ui.theme.DarkBeige
import com.example.medicinesapp.ui.theme.DarkBrown
import com.example.medicinesapp.ui.theme.LightBeige

import com.example.medicinesapp.screens.TrackerScreen
import androidx.compose.ui.res.vectorResource

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
                val items = listOf(
                    BottomNavItem(
                        title = "Трекер",
                        selectedIcon = ImageVector.vectorResource(R.drawable.tracker_selected),
                        unselectedIcon = ImageVector.vectorResource(R.drawable.tracker_unselected)
                    ),
                    BottomNavItem(
                        title = "Таблетки",
                        selectedIcon = ImageVector.vectorResource(R.drawable.tracker_selected),
                        unselectedIcon = ImageVector.vectorResource(R.drawable.tracker_unselected)
                    ),
                    BottomNavItem(
                        title = "Настройки",
                        selectedIcon = ImageVector.vectorResource(R.drawable.tracker_selected),
                        unselectedIcon = ImageVector.vectorResource(R.drawable.tracker_unselected)
                    ),

                )
                var selectedItemIndex by rememberSaveable{
                    mutableStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                    Scaffold(
                        bottomBar = {
                            NavigationBar{
                                items.forEachIndexed{index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index
                                            // navController.navigate(item.title)
                                        },
                                        label = {
                                            Text(text = item.title)
                                        },
                                        icon = {
                                            Icon(
                                                imageVector = if(index == selectedItemIndex){
                                                    item.selectedIcon
                                                } else item.unselectedIcon,
                                                contentDescription = item.title
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
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "trackerScreen") {
        composable("trackerScreen") { TrackerScreen(navController) }
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
