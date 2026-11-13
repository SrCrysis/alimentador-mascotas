package com.example.alimentador

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ComederoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comedero)

        val btnServir = findViewById<Button>(R.id.btnServir)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)
        val btnCerrar = findViewById<Button>(R.id.btnCerrar)

        actualizarComida()

        // Botón para servir comida
        btnServir.setOnClickListener {
            if (Info.comida >= 5) {
                Info.comida = Info.comida - 5

                val formato = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
                val fecha = formato.format(Date())
                Info.registros.add(0, fecha + " - Manual")

                Toast.makeText(this, "Orden enviada al comedero", Toast.LENGTH_SHORT).show()
                actualizarComida()
            } else {
                Toast.makeText(this, "No queda comida", Toast.LENGTH_SHORT).show()
            }
        }

        // Botón para ver el registro
        btnRegistro.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        // Botón para cerrar sesión
        btnCerrar.setOnClickListener {
            val intent = Intent(this, IngresoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // Muestra la comida que queda y el aviso si es poca
    fun actualizarComida() {
        val barra = findViewById<ProgressBar>(R.id.pbComida)
        val texto = findViewById<TextView>(R.id.tvPorcentaje)
        val aviso = findViewById<TextView>(R.id.tvAvisoComida)

        barra.progress = Info.comida
        texto.text = Info.comida.toString() + "%"

        if (Info.comida < 20) {
            aviso.visibility = View.VISIBLE
        } else {
            aviso.visibility = View.GONE
        }
    }
}
