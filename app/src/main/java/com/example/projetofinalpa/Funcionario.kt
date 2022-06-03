package com.example.projetofinalpa

import android.content.ContentValues

data class Funcionario(
    var id: Long,
    var nome : String,
    var comissao: Long,
    var veiculos_vendidos: Long,
    var idAutomovel: Long
    ) {
        fun toContentValues() : ContentValues {
            val valores = ContentValues()

            valores.put(TabelaBDFuncionarios.CAMPO_NOME, nome)
            valores.put(TabelaBDFuncionarios.CAMPO_COMISSAO, comissao)
            valores.put(TabelaBDFuncionarios.CAMPO_VEICULOS_VENDIDOS, veiculos_vendidos)
            valores.put(TabelaBDFuncionarios.CAMPO_AUTOMOVEL_ID, idAutomovel)

            return valores
        }
}