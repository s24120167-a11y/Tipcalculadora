package net.lrr.calculadora

import UI.TipCalculatorScreen
import ViewModel.TipCalculatorViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: TipCalculatorViewModel = viewModel()
            TipCalculatorScreen(viewModel)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}