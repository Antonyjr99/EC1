package pe.iedu.idat.ec_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.material3.MaterialTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "menu") {
        composable("menu") { Menu(navController) }
        composable("ejercicio1") { ControlScreen() }
        composable("ejercicio2") { OperacionesScreen() }
        composable("ejercicio3") { MesScreen() }
        composable("ejercicio4") { SumaScreen() }
    }
}

@Composable
fun Menu(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Menú",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(16.dp))
        MenuItem("Ejercicio 1") { navController.navigate("ejercicio1") }
        MenuItem("Ejercicio 2") { navController.navigate("ejercicio2") }
        MenuItem("Ejercicio 3") { navController.navigate("ejercicio3") }
        MenuItem("Ejercicio 4") { navController.navigate("ejercicio4") }
    }
}



@Composable
fun MenuItem(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text)
    }
}



