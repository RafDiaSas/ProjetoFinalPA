package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDAutomoveis(val db: SQLiteDatabase) {

    fun cria() {
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$CAMPO_MARCA TEXT NOT NULL," +
                "$CAMPO_MODELO TEXT NOT NULL," +
                "$CAMPO_PRECO_VENDA INTEGER NOT NULL," +
                "$CAMPO_PRECO_COMPRA INTEGER NOT NULL)")
    }

    companion object{
        const val NOME = "automoveis"
        const val CAMPO_MARCA = "marca"
        const val CAMPO_MODELO = "modelo"
        const val CAMPO_PRECO_VENDA = "precoVenda"
        const val CAMPO_PRECO_COMPRA = "precoCompra"
    }
}