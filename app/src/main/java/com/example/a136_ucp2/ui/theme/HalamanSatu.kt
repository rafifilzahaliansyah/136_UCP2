package com.example.a136_ucp2.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a136_ucp2.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    onSubmitButtonClick: (MutableList<String>) -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }
    var nimTxt by rememberSaveable {
        mutableStateOf("")
    }
    var konsentrasiTxt by rememberSaveable {
        mutableStateOf("")
    }
    var judulTxt by rememberSaveable {
        mutableStateOf("")
    }

    var listDataTxt: MutableList<String> = mutableListOf(namaTxt, nimTxt, konsentrasiTxt, judulTxt)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Formulir pengajuan Skripsi",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp))
        OutlinedTextField(value = namaTxt, onValueChange = {
            namaTxt = it
        }, label = {
            Text(text = "Nama")
        })
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(value = nimTxt, onValueChange = {
            nimTxt = it
        }, label = {
            Text(text = "NIM")
        })
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(value = konsentrasiTxt, onValueChange = {
            konsentrasiTxt = it
        }, label = { Text(
            text = "konsentrasi") },
        )
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(value = judulTxt, onValueChange = {
            judulTxt = it
        }, label = { Text(
            text = "konsentrasi") },
        )
        Spacer(modifier = Modifier.padding(16.dp))
        var DosenYgDipilih by rememberSaveable {mutableStateOf("") }

        Column (modifier = modifier,
            verticalArrangement = Arrangement.SpaceBetween) {
            Column (modifier =
            Modifier.padding(dimensionResource(R.dimen.padding_medium))){
                DosenYgDipilih.forEach { item ->
                    Row (modifier = Modifier.selectable(
                        selected = DosenYgDipilih == item,
                        onClick = {
                            DosenYgDipilih = item
                            onSelectionChanged(item)
                        }
                    ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(selected = DosenYgDipilih == item,
                            onClick = {
                                DosenYgDipilih = item
                                onSelectionChanged(item)
                            }
                        )
                        Text(item)

                    }
                }
                Divider(
                    thickness = dimensionResource(R.dimen.thickness_divider),
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
                )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false),
            horizontalArrangement =
            Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick =
                onCancelButtonClicked) {
                Text(stringResource(R.string.cancel))
            }
            Button(
                modifier = Modifier.weight(1f),
                enabled = namaTxt.isNotEmpty() && nimTxt.isNotEmpty() && konsentrasiTxt.isNotEmpty(),
                onClick = { onSubmitButtonClick(listDataTxt) }
            ) {
                Text(stringResource(R.string.next))
            }
        }

    }
}
