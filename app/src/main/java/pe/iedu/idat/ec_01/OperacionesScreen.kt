package pe.iedu.idat.ec_01


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun OperacionesScreen() {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Ingrese el primer número") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(16.dp)
        )

        OutlinedTextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Ingrese el segundo número") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = {
                val num1 = numero1.toDoubleOrNull()
                val num2 = numero2.toDoubleOrNull()

                if (num1 != null && num2 != null) {
                    resultado = when {
                        num1 == num2 -> "Resultado: ${num1 * num2}"
                        num1 > num2 -> "Resultado: ${num1 - num2}"
                        else -> "Resultado: ${num1 + num2}"
                    }
                } else {
                    resultado = "Ingrese números válidos"
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = resultado, style = MaterialTheme.typography.headlineSmall)
    }
}