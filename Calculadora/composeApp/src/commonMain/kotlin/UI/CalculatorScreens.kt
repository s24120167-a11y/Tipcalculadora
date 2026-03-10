package UI

import ViewModel.TipCalculatorViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun TipCalculatorScreen(viewModel: TipCalculatorViewModel) {
    val uiState by viewModel.uiState.collectAsState()


    DisposableEffect(Unit) {
        println("DEBUG: ha entrado en la composición")
        onDispose {
            println("DEBUG: ha salido de la composición")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Calculadora de Propinas",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(24.dp))


        TextField(
            value = uiState.billAmount,
            onValueChange = { viewModel.onBillAmountChange(it) },
            label = { Text("Monto de la factura") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))


        TextField(
            value = uiState.tipPercentage,
            onValueChange = { viewModel.onTipPercentageChange(it) },
            label = { Text("% Propina") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("¿Redondear propina?")
            Spacer(Modifier.weight(1f))
            Switch(
                checked = uiState.roundUp,
                onCheckedChange = { viewModel.onRoundUpChange(it) }
            )
        }

        Spacer(Modifier.height(24.dp))


        Text(
            text = "Propina: $${uiState.tipAmount}",
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "Total: $${uiState.totalAmount}",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}