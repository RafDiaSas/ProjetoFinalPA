package com.example.projetofinalpa

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


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

        val modelo = Modelo("XC-40")
        insereModelo(db, modelo)

        val marca = Marca("Volvo", modelo.id)
        insereMarca(db, marca)

        db.close()
    }

    @Test
    fun consegueInserirAutomovel() {
        val db = getWritableDatabase()

        val cor = Cor("Azul")
        insereCor(db, cor)

        val modelo = Modelo("XC-40")
        insereModelo(db, modelo)

        val marca = Marca("Volvo", modelo.id)
        insereMarca(db, marca)

        val automovel = Automovel("Volvo XC-40",18000,16000, 1954, marca.id, cor.id)
        insereAutomovel(db, automovel)

        db.close()
    }

    @Test
    fun consegueInserirFuncionario() {
        val db = getWritableDatabase()

        insereFuncionario(db, Funcionario("Pedro", 15, 28))

        db.close()
    }

    @Test
    fun consegueInserirVenda() {
        val db = getWritableDatabase()

        val cor = Cor("Azul")
        insereCor(db, cor)

        val modelo = Modelo("XC-40")
        insereModelo(db, modelo)

        val marca = Marca("Volvo", modelo.id)
        insereMarca(db, marca)

        val automovel = Automovel("Volvo XC-40",18000,16000, 1954, marca.id, cor.id)
        insereAutomovel(db, automovel)

        val funcionario = Funcionario("Pedro", 15, 28)
        insereFuncionario(db, funcionario)

        insereVenda(db, Venda(4000, funcionario.id, automovel.id))

        db.close()
    }

    @Test
    fun consegueAlterarCor() {
        val db = getWritableDatabase()

        val cor = Cor("Teste")
        insereCor(db, cor)

        cor.nome = "Cinzento"

        val registosAlterados = TabelaBDCores(db).update(
            cor.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("${cor.id}"))

        assertEquals(1, registosAlterados)

        db.close()
    }

    @Test
    fun consegueAlterarModelo() {
        val db = getWritableDatabase()

        val modelo = Modelo("Teste")
        insereModelo(db, modelo)

        modelo.nome = "300SL"

        val registosAlterados = TabelaBDModelos(db).update(
            modelo.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("${modelo.id}"))

        assertEquals(1, registosAlterados)

        db.close()
    }

    @Test
    fun consegueAlterarMarca() {
        val db = getWritableDatabase()

        val cor = Cor("Azul")
        insereCor(db, cor)

        val modelo = Modelo("XC-40")
        insereModelo(db, modelo)

        val marca = Marca("Volvo", modelo.id)
        insereMarca(db, marca)

        val automovel = Automovel("Volvo XC-40",18000,16000, 1954, marca.id, cor.id)
        insereAutomovel(db, automovel)

        val funcionario = Funcionario("Pedro", 15, 28)
        insereFuncionario(db, funcionario)

        val registosAlterados = TabelaBDMarcas(db).update(
            modelo.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("${marca.id}"))

        assertEquals(1, registosAlterados)

        db.close()
    }

    @Test
    fun consegueAlterarAutomovel() {
        val db = getWritableDatabase()

        val corCinzento = Cor("Cinzento")
        insereCor(db, corCinzento)

        val corVermelho = Cor("Vermelho")
        insereCor(db, corVermelho)

        val modelo = Modelo("300SL")
        insereModelo(db, modelo)

        val marcaMercedes = Marca("Mercedes", modelo.id)
        insereMarca(db, marcaMercedes)

        val marcaToyota = Marca("Toyota", modelo.id)
        insereMarca(db, marcaToyota)

        val automovel = Automovel("Teste", 115000,100000,1954, marcaMercedes.id, corCinzento.id)

        automovel.nome = "Toyota 300SL"
        automovel.precoVenda = 16000
        automovel.precoCompra = 12000
        automovel.ano = 1995
        automovel.idMarca = marcaToyota.id
        automovel.idCor = corVermelho.id

        val registosAlterados = TabelaBDAutomoveis(db).update(
            modelo.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("${automovel.id}"))

        assertEquals(1, registosAlterados)

        db.close()
    }

    @Test
    fun consegueAlterarFuncionario() {
        val db = getWritableDatabase()

        val funcionario = Funcionario("Teste",20, 190)
        insereFuncionario(db, funcionario)

        funcionario.nome = "Camilo"
        funcionario.comissao = 15
        funcionario.veiculos_vendidos = 191

        val registosAlterados = TabelaBDModelos(db).update(
            funcionario.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("${funcionario.id}"))

        assertEquals(1, registosAlterados)

        db.close()
    }

    @Test
    fun consegueAlterarVenda() {
        val db = getWritableDatabase()

        val cor = Cor("Azul")
        insereCor(db, cor)

        val modelo = Modelo("XC-40")
        insereModelo(db, modelo)

        val marca = Marca("Volvo", modelo.id)
        insereMarca(db, marca)

        val automovel = Automovel("Volvo XC-40",18000,16000, 1954, marca.id, cor.id)
        insereAutomovel(db, automovel)

        val funcionario = Funcionario("Pedro", 15, 28)
        insereFuncionario(db, funcionario)

        val registosAlterados = TabelaBDModelos(db).update(
            funcionario.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("${funcionario.id}"))

        assertEquals(1, registosAlterados)

        db.close()
    }
}

