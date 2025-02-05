package com.example.inventory.ui.login

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.inventory.ui.navigation.AppScreens
import com.example.inventory.ui.AppViewModelProvider
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel(factory = AppViewModelProvider.Factory)
){
    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        topBar ={
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "SICEnet",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor =MaterialTheme.colorScheme.primary
                )
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier . fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    value = viewModel.matricula,
                    onValueChange = {
                        viewModel.updateMatricula(it)
                    },
                    label = { Text("Numero de control") }
                )
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    value = viewModel.password,
                    onValueChange = {
                        viewModel.updatePassword(it)
                    },
                    label = {
                        Text("Contraseña")
                    }
                )
                Button(
                    onClick = {

                        // VALIDA QUE LOS CAMPOS NO ESTEN VACIOS
                        if(viewModel.validate()){

                            // CORUTINA
                            coroutineScope.launch {
                                // VERIFICA SI EL ACCESO ES CORRECTO
                                if(viewModel.getAccceso()){
                                    viewModel.updateMatricula("")
                                    viewModel.updatePassword("")

                                    // SI ES CORRECTO EL ACCESO NAVEGA
                                    navController.navigate(AppScreens.AlumnoInfoScreen.route)

                                } else {
                                    //ENVIAR ALERTA DE QUE NO SE LOGRO INICIAR SESION
                                    Log.d("SCREEN", "Entro al else de getAcesso")
                                }
                            }
                        } else {
                            //MANDAR ALERTA DE QUE NO SE VALIDARON LOS CAMPOS
                        }
                    },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    Text(text = "INGRESAR", modifier = Modifier.padding(PaddingValues(4.dp)))
                }
            }
        }
    }

}