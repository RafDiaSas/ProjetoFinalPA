package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDFuncionarios (val db: SQLiteDatabase){

    fun cria() {
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$CAMPO_NOME TEXT NOT NULL," +
                "$CAMPO_COMISSAO INTEGER NOT NULL," +
                "$CAMPO_VEICULOS_VENDIDOS INTEGER NOT NULL," +
                "FOREIGN KEY (${TabelaBDVendas.CAMPO_AUTOMOVEL_ID}_ID) REFERENCES ${TabelaBDAutomoveis.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)")
    }

    companion object{
        const val NOME = "funcionarios"
        const val CAMPO_NOME = "nome"
        const val CAMPO_COMISSAO = "comissão"
        const val CAMPO_VEICULOS_VENDIDOS = "veiculosVendidos"
    }
}