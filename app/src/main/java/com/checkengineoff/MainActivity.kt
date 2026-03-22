package com.checkengineoff

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.auth.login.presentation.ui.LoginScreen
import com.auth.register.presentation.ui.UserRegistrationScreen
import com.bold.core.ui.theme.CheckEngineOffMainTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckEngineOffMainTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "login"
                ) {
                    composable("login") {
                        LoginScreen(
                            onNavigateRegister = { navController.navigate("register") }
                        )
                    }

                    composable("register") {
                        UserRegistrationScreen(
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}