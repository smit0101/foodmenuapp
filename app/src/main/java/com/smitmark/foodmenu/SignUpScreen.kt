package com.smitmark.foodmenu.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.smitmark.foodmenu.data.client
import com.smitmark.foodmenu.model.User
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(navController: NavHostController){
    val coroutineScope = rememberCoroutineScope()
    var firstName by remember {
        mutableStateOf("")
    }
    var lastName by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        TextField(value = firstName, onValueChange = {firstName = it} )
        TextField(value = lastName, onValueChange = {lastName = it} )
        TextField(value = email, onValueChange = {email = it} )
        TextField(value = password, onValueChange = {password = it} )
        Button(onClick = {
            coroutineScope.launch {
                client.post("https://foodmenuapp-pgokju5beq-el.a.run.app/add/user"){
                    contentType(ContentType.Application.Json)
                    setBody(User(firstName,lastName,email,password))
                }
            }
        }) {
            Text(text = "SignUp")
        }
    }
}