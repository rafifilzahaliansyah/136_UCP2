package com.example.a136_ucp2.ui.theme

import androidx.lifecycle.ViewModel
import com.example.a136_ucp2.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setContact(listData: MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listData[0],
                nim = listData[1],
                konsentrasi = listData[2],
                judul = listData[3]
            )
        }
    }
    fun setdosen(dosenPilihan: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dosen = dosenPilihan)
        }
    }
}
fun setpilihdosen(pilihDosen: String) {
    _uiState.update { currentState -> currentState.copy(dosen  = pilihDosen) }
}