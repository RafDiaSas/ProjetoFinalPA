package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDMarcas(db: SQLiteDatabase) : TabelaBD(db, NOME) {
    override fun cria() {
        db.execSQL("CREATE TABLE ${TabelaBDFuncionarios.NOME} (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$CAMPO_NOME TEXT NOT NULL," +
                "FOREIGN KEY ($CAMPO_MODELO_ID) REFERENCES ${TabelaBDModelos.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)")
    }

    companion object {
        const val NOME = "marcas"
        const val CAMPO_NOME = "nome"
        const val CAMPO_MODELO_ID = "modelo_id"
    }
}