package com.example.projetofinalpa

import android.content.ContentValues

data class Marca (
    var nome: String,
    var id: Long = -1,
    var idModelo: Long
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDMarcas.CAMPO_NOME, nome)
        valores.put(TabelaBDMarcas.CAMPO_MODELO_ID, idModelo)

        return valores
    }
}