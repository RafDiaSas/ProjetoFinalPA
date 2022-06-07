package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class BaseDadosTest {
    private fun appContext() =
        InstrumentationRegistry.getInstrumentation().targetContext

    private fun getWritableDatabase(): SQLiteDatabase {
        val openHelper = BDStandOpenHelper(appContext())
        return openHelper.writableDatabase
    }

    private fun insereCor(db: SQLiteDatabase, cor: Cor) {
        cor.id = TabelaBDCores(db).insert(cor.toContentValues())
        assertNotEquals(-1, cor.id)
    }

    private fun insereModelo(db: SQLiteDatabase, modelo: Modelo) {
        modelo.id = TabelaBDModelos(db).insert(modelo.toContentValues())
        assertNotEquals(-1, modelo.id)
    }

    private fun insereMarca(db: SQLiteDatabase, marca: Marca) {
        marca.id = TabelaBDMarcas(db).insert(marca.toContentValues())
        assertNotEquals(-1, marca.id)
    }

    private fun insereAutomovel(db: SQLiteDatabase, automovel: Automovel) {
        automovel.id = TabelaBDAutomoveis(db).insert(automovel.toContentValues())
        assertNotEquals(-1, automovel.id)
    }

    private fun insereFuncionario(db: SQLiteDatabase, funcionario: Funcionario) {
        funcionario.id = TabelaBDFuncionarios(db).insert(funcionario.toContentValues())
        assertNotEquals(-1, funcionario.id)
    }

    private fun insereVenda(db: SQLiteDatabase, venda: Venda) {
        venda.id = TabelaBDVendas(db).insert(venda.toContentValues())
        assertNotEquals(-1, venda.id)
    }

    @Before
    fun apagaBaseDados() = appContext().deleteDatabase(BDStandOpenHelper.NOME)

    @Test
    fun consegueAbrirBaseDados() {
        val openHelper = BDStandOpenHelper(appContext())
        val db = openHelper.readableDatabase

        assertTrue(db.isOpen)

        db.close()
    }

    @Test
    fun consegueInserirCor() {
        val db = getWritableDatabase()

        insereCor(db, Cor("Verde"))

        db.close()
    }

    @Test
    fun consegueInserirModelo() {
        val db = getWritableDatabase()

        insereModelo(db, Modelo("XC-40"))

        db.close()
    }

    @Test
    fun consegueInserirMarca() {
        val db = getWritableDatabase()

        insereModelo(db, Modelo("XC-40"))

        insereMarca(db, Marca("Volvo"), marca.id)

        db.close()
    }

    @Test
    fun consegueInserirAutomovel() {
        val db = getWritableDatabase()

        insereAutomovel(db, Automovel("Volvo XC40"))


        db.close()
    }

    @Test
    fun consegueInserirFuncionario() {
        val db = getWritableDatabase()

        insereFuncionario(db, Funcionario("Pedro"))

        db.close()
    }

    @Test
    fun consegueInserirVenda() {
        val db = getWritableDatabase()

        insereVenda(db, Venda("VolvoXC40--sold"))

        db.close()
    }

    @Test
    fun consegueInserirVenda() {
        val db = getWritableDatabase()

        insereVenda(db, Venda("VolvoXC40--sold"))

        db.close()
    }
}

