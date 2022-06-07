package com.example.projetofinalpa

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDStandOpenHelper (context: Context?) : SQLiteOpenHelper(context, NOME, null, VERSAO) {

    override fun onCreate(db: SQLiteDatabase?) {

        requireNotNull(db)

        TabelaBDAutomoveis(db).cria()
        TabelaBDFuncionarios(db).cria()
        TabelaBDVendas(db).cria()
        TabelaBDMarcas(db).cria()
        TabelaBDModelos(db).cria()
        TabelaBDCores(db).cria()
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    companion object{
        const val NOME = "stand.db"
        private const val VERSAO = 1
    }
}