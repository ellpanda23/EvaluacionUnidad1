package com.example.inventory.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inventory.ui.alumno.AlumnoInfoScreen
import com.example.inventory.ui.login.LoginScreen

@Composable
fun AppNavigation()
{
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route){
        composable(AppScreens.LoginScreen.route)
        {
            LoginScreen(navController = navController)
        }
        composable(AppScreens.AlumnoInfoScreen.route)
        {
            AlumnoInfoScreen(navController = navController)
        }
    }
}