package pe.iedu.idat.ec_01

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.Alignment

@Composable
fun SumaScreen() {
    var mostrarSumas by remember { mutableStateOf(false) }
    var resultado by remember { mutableStateOf("") }

    fun sumaDeDigitos(numero: Int): Int {
        return numero.toString().map { it.toString().toInt() }.sum()
    }

    LaunchedEffect(mostrarSumas) {
        if (mostrarSumas) {
            val resultados = (23..99).joinToString("\n") { numero ->
                "Número: $numero, Suma de dígitos: ${sumaDeDigitos(numero)}"
            }
            resultado = resultados
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Suma de los dígitos de cada número del 23 al 99",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = { mostrarSumas = true },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Mostrar Sumas")
        }

        if (mostrarSumas) {
            Text(
                text = resultado,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Left
            )
        }
    }
}




