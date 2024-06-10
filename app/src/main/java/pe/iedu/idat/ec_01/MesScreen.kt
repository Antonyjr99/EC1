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
fun MesScreen() {
    var numeroMes by remember { mutableStateOf("") }
    var mesEnLetras by remember { mutableStateOf("") }

    val meses = listOf(
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = numeroMes,
            onValueChange = { numeroMes = it },
            label = { Text("Ingrese un número del 1 al 12") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = {
                val numero = numeroMes.toIntOrNull()
                mesEnLetras = if (numero != null && numero in 1..12) {
                    "Mes: ${meses[numero - 1]}"
                } else {
                    "Número no válido"
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Mostrar Mes")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = mesEnLetras, style = MaterialTheme.typography.headlineSmall)
    }
}
