
package pe.iedu.idat.ec_01

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ControlScreen() {
    var selectedVehiculo by remember { mutableStateOf("") }
    var tasaAlcohol by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    val vehiculos = listOf("C", "A", "T", "M")
    val vehiculoLabel = if (selectedVehiculo.isEmpty()) "Indicador de vehículo (C, A, T, M)" else selectedVehiculo

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = vehiculoLabel,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier
                    .padding(16.dp)
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                vehiculos.forEach { vehiculo ->
                    DropdownMenuItem(
                        text = { Text(vehiculo) },
                        onClick = {
                            selectedVehiculo = vehiculo
                            expanded = false
                        }
                    )
                }
            }
        }

        OutlinedTextField(
            value = tasaAlcohol,
            onValueChange = { tasaAlcohol = it },
            label = { Text("Tasa de alcohol") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = {
                val tasaMaxima = when (selectedVehiculo) {
                    "C" -> 0.3
                    "A" -> 0.3
                    "T" -> 0.5
                    "M" -> 0.3
                    else -> {
                        resultado = "Indicador de vehículo no válido"
                        return@Button
                    }
                }

                val positivo = (tasaAlcohol.toDoubleOrNull() ?: 0.0) > tasaMaxima

                resultado = if (positivo) "Positivo" else "Negativo"
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = resultado, style = MaterialTheme.typography.headlineSmall)
    }
}
