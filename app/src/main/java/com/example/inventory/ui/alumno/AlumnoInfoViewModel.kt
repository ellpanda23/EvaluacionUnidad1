package com.example.inventory.ui.alumno


import androidx.lifecycle.ViewModel
import com.example.inventory.data.SicenetRepository
import com.example.inventory.model.Alumno

class AlumnoInfoViewModel(
    private val networkSicenetRepository: SicenetRepository,
) : ViewModel() {
    // BUSCA EL ALUMNO EN INTERNET
    suspend fun getAlumno(): Alumno {
        return networkSicenetRepository.getAlumno()
    }
}