package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApp()
        }
    }
}

@Composable
fun CalculatorApp() {

    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("Result will appear here") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Simple Calculator", fontSize = 26.sp)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Enter First Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Enter Second Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {

            Button(onClick = {
                result = (num1.toDoubleOrNull() ?: 0.0 +
                (num2.toDoubleOrNull() ?: 0.0)).toString()
            }) { Text("+") }

            Button(onClick = {
                result = ((num1.toDoubleOrNull() ?: 0.0) -
                        (num2.toDoubleOrNull() ?: 0.0)).toString()
            }) { Text("-") }

            Button(onClick = {
                result = ((num1.toDoubleOrNull() ?: 0.0) *
                        (num2.toDoubleOrNull() ?: 0.0)).toString()
            }) { Text("×") }

            Button(onClick = {
                val n1 = num1.toDoubleOrNull() ?: 0.0
                val n2 = num2.toDoubleOrNull() ?: 0.0
                result = if (n2 == 0.0) {
                    "Cannot divide by zero"
                } else {
                    (n1 / n2).toString()
                }
            }) { Text("÷") }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(result, fontSize = 20.sp)
    }
}
