package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDModelos(db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria() {
        db.execSQL("CREATE TABLE ${TabelaBDFuncionarios.NOME} (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${TabelaBDModelos.CAMPO_NOME} TEXT NOT NULL)")
    }

    companion object {
        const val NOME = "modelos"
        const val CAMPO_NOME = "modelo"
        const val CAMPO_MODELO_ID = "modelo_id"
    }
}