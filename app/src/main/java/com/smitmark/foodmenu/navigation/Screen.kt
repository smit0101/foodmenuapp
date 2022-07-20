package com.smitmark.foodmenu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.smitmark.foodmenu.LoginScreen
import com.smitmark.foodmenu.MainScreen
import com.smitmark.foodmenu.ui.theme.SignUpScreen

sealed interface Screen{
    val route:String
}

object SignUpScreen : Screen{
    override val route: String
        get() = "signUpScreen"
}

object LoginScreen : Screen{
    override val route: String
        get() = "loginScreen"
}

object MainScreen : Screen{
    override val route: String
        get() = "mainScreen"
}


@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController,
            startDestination = LoginScreen.route){
        composable(route = SignUpScreen.route){
            SignUpScreen(navController)
        }
        composable(route = LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(route = MainScreen.route){
            MainScreen()
        }

    }
}