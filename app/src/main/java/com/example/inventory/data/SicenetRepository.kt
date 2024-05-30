package com.example.inventory.data

import com.example.inventory.model.Alumno


// INTERFAZ DEFINE LA ESTRUCTURA
interface SicenetRepository {

    suspend fun getAcceso(m: String, p: String): Boolean

    suspend fun getAlumno(): Alumno

}