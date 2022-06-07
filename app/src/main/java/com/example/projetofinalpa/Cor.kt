package com.example.projetofinalpa

import android.content.ContentValues

data class Cor (
    var nome: String,
    var id: Long = -1

) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDCores.CAMPO_NOME, nome)
        return valores
    }
}