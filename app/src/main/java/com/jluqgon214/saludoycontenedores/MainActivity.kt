@file:OptIn(ExperimentalMaterial3Api::class)

package com.jluqgon214.saludoycontenedores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.jluqgon214.saludoycontenedores.ui.theme.SaludoYContenedoresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaludoYContenedoresTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Saludar()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Saludar() {
    var show by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (show) {
            ShowDialog()
        }

        Button(onClick = { show = true }) {
            Text(text = "Saludar")
        }
        Text(text = "")
    }
}


@Composable

fun ShowDialog() {
    var name by rememberSaveable { mutableStateOf(TextFieldValue("")) }
    AlertDialog(onDismissRequest = {/*TODO*/ }, confirmButton = {/*TODO*/ }, title = { Text(text = "Configuración") },
        icon = {
            Icon(
                painter = (painterResource(id = R.drawable.settings_icon)),
                contentDescription = "Icono de Configuracion"
            )
        })

    Dialog(onDismissRequest = { /*TODO*/ }) {
        OutlinedTextField(value = name, onValueChange = {name = it}, label = { Text(text = "Nombre")})
    }
}
