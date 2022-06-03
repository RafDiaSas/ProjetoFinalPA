package com.example.projetofinalpa

import android.content.ContentValues

data class Automovel (
    var id: Long,
    var precoVenda: Long,
    var precoCompra: Long,
    var idMarca: Long,
    var idCor: Long
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDAutomoveis.CAMPO_PRECO_VENDA, precoVenda)
        valores.put(TabelaBDAutomoveis.CAMPO_PRECO_COMPRA, precoCompra)
        valores.put(TabelaBDAutomoveis.CAMPO_MARCA_ID, idMarca)
        valores.put(TabelaBDAutomoveis.CAMPO_COR_ID, idCor)

        return valores
    }
}