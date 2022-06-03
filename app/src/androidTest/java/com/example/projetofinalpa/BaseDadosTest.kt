package com.example.projetofinalpa

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class BaseDadosTest {

    fun appContext() = InstrumentationRegistry.getInstrumentation().targetContext


    @Before
    fun apagaBaseDados() = appContext().deleteDatabase(BDStandOpenHelper.NOME)

    @Test
    fun consegueAbrirBaseDados() {
        val openHelper = BDStandOpenHelper(appContext())
        val db = openHelper.readableDatabase

        assertTrue(db.isOpen)

        db.close()
    }
}