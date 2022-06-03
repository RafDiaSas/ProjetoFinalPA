package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDAutomoveis(db: SQLiteDatabase) : TabelaBD(db, NOME){

    override fun cria() {
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$CAMPO_PRECO_VENDA INTEGER NOT NULL," +
                "$CAMPO_PRECO_COMPRA INTEGER NOT NULL," +
                "FOREIGN KEY ($CAMPO_MARCA_ID) REFERENCES ${TabelaBDMarcas.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT," +
                "FOREIGN KEY ($CAMPO_COR_ID) REFERENCES ${TabelaBDCores.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)")
    }

    companion object{
        const val NOME = "automoveis"
        const val CAMPO_PRECO_VENDA = "preco_venda"
        const val CAMPO_PRECO_COMPRA = "preco_compra"
        const val CAMPO_MARCA_ID = "marca_id"
        const val CAMPO_COR_ID = "cor_id"
    }
}