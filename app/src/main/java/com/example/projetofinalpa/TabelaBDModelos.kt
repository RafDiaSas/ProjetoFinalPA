package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDModelos(db: SQLiteDatabase) : TabelaBD(db, TabelaBDVendas.NOME) {
    override fun cria() {
        db.execSQL("CREATE TABLE ${TabelaBDFuncionarios.NOME} (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${TabelaBDMarcas.CAMPO_NOME} TEXT NOT NULL," +
                "FOREIGN KEY (${TabelaBDModelos.CAMPO_MODELO_ID}_ID) REFERENCES ${TabelaBDMarcas.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)")
    }

    companion object {
        const val NOME = "marcas"
        const val CAMPO_NOME = "fabricante"
        const val CAMPO_MARCA_ID = "marca_id"
    }
}