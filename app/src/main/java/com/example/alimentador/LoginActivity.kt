package com.example.alimentador

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class IngresoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etPass = findViewById<EditText>(R.id.etPass)
        val tvAviso = findViewById<TextView>(R.id.tvAviso)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)

        btnEntrar.setOnClickListener {
            val correo = etCorreo.text.toString()
            val pass = etPass.text.toString()

            // Si falta algún dato muestra el aviso
            if (correo == "" || pass == "") {
                tvAviso.visibility = View.VISIBLE
            } else {
                // Por ahora entra con cualquier dato
                val intent = Intent(this, ComederoActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
