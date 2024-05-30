package com.example.inventory.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Acceso(
    var acceso:Boolean = false,
    var estatus:String = "",
    var tipoUsuario:String = "",
    var contrasenia:String = "",
    var matricula:String = "",
)
