package ViewModel

data class TipUiState(
    val billAmount: String = "",
    val tipPercentage: String = "15",
    val roundUp: Boolean = false,
    val tipAmount: String = "0.00",
    val totalAmount: String = "0.00"
)