package com.example.mvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mvvm.model.Siswa
import com.example.mvvm.R
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    statusUiSiswa: Siswa,
    onBack: () -> Unit
) {
    val items = listOf(
        Pair(stringResource(id = R.string.nama), statusUiSiswa.nama),
        Pair(stringResource(id = R.string.gender), statusUiSiswa.gender),
        Pair(stringResource(id = R.string.alamat), statusUiSiswa.alamat),
    )
    Scaffold(modifier = Modifier,
        {TopAppBar(
            title = {Text( stringResource(id = R.string.detail), color = Color.White)},
            colors = TopAppBarDefaults.topAppBarColors(colorResource(id = R.color.purple_500)))
        }) { isiRuang ->
        Column (modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.SpaceBetween){
            Column (modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                items.forEach { item ->
                    Column {
                        Text(item.first.uppercase(), fontSize = 16.sp)
                        Text(text = item.second, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }
                    Divider(thickness = dimensionResource(id = R.dimen.thickness_divider))
                }
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onBack
                ) {
                    Text(stringResource(id = R.string.back))
                }
            }
        }
    }
}