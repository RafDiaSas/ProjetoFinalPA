package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDVendas (db: SQLiteDatabase) : TabelaBD(db, NOME){

    override fun cria() {
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$CAMPO_LUCRO INTEGER NOT NULL," +
                "FOREIGN KEY ($CAMPO_FUNCIONARIO_ID) REFERENCES ${TabelaBDFuncionarios.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT," +
                "FOREIGN KEY ($CAMPO_AUTOMOVEL_ID) REFERENCES ${TabelaBDAutomoveis.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)")
    }

    companion object{
        const val NOME = "vendas"
        const val CAMPO_LUCRO = "lucro"  //lucro = pVenda - pCompra - (comissao * pVenda)
        const val CAMPO_FUNCIONARIO_ID ="funcionario_ID"
        const val CAMPO_AUTOMOVEL_ID ="automovel_ID"
    }
}