package ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TipCalculatorViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TipUiState())
    val uiState: StateFlow<TipUiState> = _uiState.asStateFlow()

    fun onBillAmountChange(newValue: String) {
        _uiState.update { it.copy(billAmount = newValue) }
        calculateTip()
    }

    fun onTipPercentageChange(newValue: String) {
        _uiState.update { it.copy(tipPercentage = newValue) }
        calculateTip()
    }

    fun onRoundUpChange(newValue: Boolean) {
        _uiState.update { it.copy(roundUp = newValue) }
        calculateTip()
    }

    private fun calculateTip() {
        val amount = _uiState.value.billAmount.toDoubleOrNull() ?: 0.0
        val tipPercent = _uiState.value.tipPercentage.toDoubleOrNull() ?: 0.0

        var tip = amount * (tipPercent / 100)

        if (_uiState.value.roundUp) {
            tip = kotlin.math.ceil(tip)
        }

        val total = amount + tip

        _uiState.update {
            it.copy(
                tipAmount = tip.toString(),
                totalAmount = total.toString()
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        println("DEBUG: TipCalculatorViewModel ha sido destruido (onCleared)")
    }
}