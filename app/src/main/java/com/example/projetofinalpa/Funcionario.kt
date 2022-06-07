package com.example.projetofinalpa

import android.content.ContentValues

data class Funcionario(
    var nome : String,
    var comissao: Long,
    var veiculos_vendidos: Long,
    var id: Long = -1
    ) {
        fun toContentValues() : ContentValues {
            val valores = ContentValues()

            valores.put(TabelaBDFuncionarios.CAMPO_NOME, nome)
            valores.put(TabelaBDFuncionarios.CAMPO_COMISSAO, comissao)
            valores.put(TabelaBDFuncionarios.CAMPO_VEICULOS_VENDIDOS, veiculos_vendidos)

            return valores
        }
}