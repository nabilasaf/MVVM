package com.example.mvvm.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
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
            colors = TopAppBarDefaults.topAppBarColors(colorResource(id = R.color.purple_500))}) {}