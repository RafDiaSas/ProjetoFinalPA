package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDCores(db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria() {
        db.execSQL("CREATE TABLE ${TabelaBDFuncionarios.NOME} (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${TabelaBDCores.CAMPO_NOME} TEXT NOT NULL)")
    }

    companion object {
        const val NOME = "cores"
        const val CAMPO_NOME = "cor"
    }
}