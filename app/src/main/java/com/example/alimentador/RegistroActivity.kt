package com.example.alimentador

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val lista = findViewById<ListView>(R.id.lvRegistro)
        val btnAtras = findViewById<Button>(R.id.btnAtras)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, Info.registros)
        lista.adapter = adaptador

        btnAtras.setOnClickListener {
            finish()
        }
    }
}
