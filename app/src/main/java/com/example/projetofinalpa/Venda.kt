package com.example.projetofinalpa

import android.content.ContentValues

data class Venda (
    var lucro: Long,
    var idFuncionario: Long,
    var idAutomovel: Long,
    var id: Long = -1
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDVendas.CAMPO_LUCRO, lucro)
        valores.put(TabelaBDVendas.CAMPO_FUNCIONARIO_ID, idFuncionario)
        valores.put(TabelaBDVendas.CAMPO_AUTOMOVEL_ID, idAutomovel)

        return valores
    }
}