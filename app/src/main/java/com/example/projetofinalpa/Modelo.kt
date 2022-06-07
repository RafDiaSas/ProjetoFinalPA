package com.example.projetofinalpa

import android.content.ContentValues

data class Modelo (
    var nome: String,
    var id: Long = -1

) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDModelos.CAMPO_NOME, nome)
        return valores
    }
}
