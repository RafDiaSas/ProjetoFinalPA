package com.example.projetofinalpa

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDStandOpenHelper (
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {

        requireNotNull(db)

        TabelaBDAutomoveis(db).cria()
        TabelaBDFuncionarios(db).cria()
        TabelaBDVendas(db).cria()
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}