package com.checkengineoff

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.checkengineoff.auth.login.presentation.ui.LoginScreenRoute
import com.checkengineoff.auth.register.presentation.ui.UserRegistrationScreenRoute

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ) {

        composable(AppScreen.Login.route) {
            LoginScreenRoute(
                onNavigateRegister = {
                    navController.navigate("register")
                }
            )
        }

        composable(AppScreen.Register.route) {
            UserRegistrationScreenRoute(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
