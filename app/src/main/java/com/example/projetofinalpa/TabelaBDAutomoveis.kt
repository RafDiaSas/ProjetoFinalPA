package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDAutomoveis(db: SQLiteDatabase) : TabelaBD(db, TabelaBDVendas.NOME){

    override fun cria() {
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$CAMPO_MARCA TEXT NOT NULL," +
                "$CAMPO_MODELO TEXT NOT NULL," +
                "$CAMPO_COR TEXT NOT NULL," +
                "$CAMPO_PRECO_VENDA INTEGER NOT NULL," +
                "$CAMPO_PRECO_COMPRA INTEGER NOT NULL)")
    }

    companion object{
        const val NOME = "automoveis"
        const val CAMPO_MARCA = "marca"
        const val CAMPO_MODELO = "modelo"
        const val CAMPO_COR = "cor"
        const val CAMPO_PRECO_VENDA = "preco_venda"
        const val CAMPO_PRECO_COMPRA = "preco_compra"
    }
}