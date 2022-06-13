package com.example.projetofinalpa

import android.content.ContentValues

data class Automovel (
    var nome: String,
    var precoVenda: Long,
    var precoCompra: Long,
    var ano: Long,
    var idMarca: Long,
    var idCor: Long,
    var id: Long = -1
) {
    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDAutomoveis.CAMPO_NOME, nome)
        valores.put(TabelaBDAutomoveis.CAMPO_PRECO_VENDA, precoVenda)
        valores.put(TabelaBDAutomoveis.CAMPO_PRECO_COMPRA, precoCompra)
        valores.put(TabelaBDAutomoveis.CAMPO_MARCA_ID, idMarca)
        valores.put(TabelaBDAutomoveis.CAMPO_COR_ID, idCor)

        return valores
    }
}