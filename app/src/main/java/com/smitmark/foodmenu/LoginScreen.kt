package com.smitmark.foodmenu

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.smitmark.foodmenu.navigation.SignUpScreen

@Composable
fun LoginScreen(navController:NavHostController){
    Button(onClick = { navController.navigate(SignUpScreen.route)}) {
        Text(text = "Login")
    }
}