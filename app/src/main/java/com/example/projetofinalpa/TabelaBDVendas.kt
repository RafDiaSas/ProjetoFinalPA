package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDVendas (val db: SQLiteDatabase){

    fun cria() {
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$CAMPO_LUCRO INTEGER NOT NULL," +
                "FOREIGN KEY ($CAMPO_FUNCIONARIO_ID) REFERENCES ${TabelaBDFuncionarios.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)")
    }

    companion object{
        const val NOME = "vendas"
        const val CAMPO_LUCRO = "lucro"
        const val CAMPO_FUNCIONARIO_ID ="funcionarioID"
        const val CAMPO_AUTOMOVEL_ID ="automovelID"
    }
}