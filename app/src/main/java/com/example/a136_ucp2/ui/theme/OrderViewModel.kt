package com.example.a136_ucp2.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.a136_ucp2.data.OrderUIState
import com.example.pertemuan5.Data.DataForm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CobaViewModel : ViewModel() {
    var namaUsr: String by mutableStateOf("")
        private set
    var noTlp: String by mutableStateOf("")
        private set
    var Email: String by mutableStateOf("")
        private set
    var alamatUsr: String by mutableStateOf("")
        private set
    var jenisKl: String by mutableStateOf("")
        private set
    var stts: String by mutableStateOf("")
        private set
    private val _uiState = MutableStateFlow(OrderUIState())
    val uiState: StateFlow<OrderUIState> = _uiState.asStateFlow()

    fun insertData(nm: String, tlp: String, almt: String, jk: String, sttss : String,eml : String) {
        namaUsr = nm;
        noTlp = tlp;
        Email = eml;
        alamatUsr = almt;
        jenisKl = jk;
        stts = sttss;
    }

    fun setJenisK(pilihJK: String) {
        _uiState.update { currentState -> currentState.copy(dosen = = pilihDosen) }
    }
    fun setStatus(pilihstatus: String) {
        _uiState.update { currentState -> currentState.copy(stattus = pilihstatus) }
    }
}
