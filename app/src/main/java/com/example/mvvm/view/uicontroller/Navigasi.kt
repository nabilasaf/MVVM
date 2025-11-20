package com.example.mvvm.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.model.DataJK.JenisK
import com.example.mvvm.view.FormSiswa
import com.example.mvvm.view.TampilSiswa
import com.example.mvvm.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(isiRuang)) {
                composable (route = Navigasi.Formulir.name){
                    val konteks = LocalContext.current
                    FormSiswa(
                        modifier = Modifier,
                        pilihanJK = JenisK.map {id -> konteks.resources.getString(id)},
                        onSubmit = {
                            viewModel.setSiswa(it)
                            navController.navigate(Navigasi.Detail.name)
                        }
                    )
                }
                composable (route = Navigasi.Detail.name ){
                    TampilSiswa(
                        statusUiSiswa = uiState.value,
                        onBack = {cancleAndBackToFormulir(navController)}
                    )
                }
            }
        }
}

private fun cancleAndBackToFormulir(
    navController: NavController
){
    navController.popBackStack(Navigasi.Formulir.name, inclusive = false)
}