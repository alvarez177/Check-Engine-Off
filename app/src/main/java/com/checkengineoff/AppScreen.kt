package com.checkengineoff

sealed class AppScreen(val route: String) {
    object Login: AppScreen("Login")
    object Register: AppScreen("Register")
}