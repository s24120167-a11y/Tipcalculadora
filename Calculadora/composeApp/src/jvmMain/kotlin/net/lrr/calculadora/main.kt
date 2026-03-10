package net.lrr.calculadora

import ViewModel.TipCalculatorViewModel
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.lifecycle.viewmodel.compose.viewModel
import UI.TipCalculatorScreen
import androidx.compose.material.MaterialTheme


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Calculate Tip - Desktop"
    ) {
        val viewModel: TipCalculatorViewModel = viewModel { TipCalculatorViewModel() }

        MaterialTheme {
            TipCalculatorScreen(viewModel)
        }
    }
}