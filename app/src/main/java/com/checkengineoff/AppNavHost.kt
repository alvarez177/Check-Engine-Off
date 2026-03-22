package com.checkengineoff

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.auth.login.presentation.ui.LoginScreen
import com.auth.register.presentation.ui.UserRegistrationScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ) {

        composable(AppScreen.Login.route) {
            LoginScreen(
                onNavigateRegister = { navController.navigate("register") }
            )
        }

        composable(AppScreen.Register.route) {
            UserRegistrationScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
