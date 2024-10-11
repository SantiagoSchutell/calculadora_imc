package com.example.aulacalculadoraimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)

        val Bundle = intent.extras
        if (Bundle != null) {

            val peso = Bundle.getDouble("peso")
            val altura = Bundle.getDouble("altura")

            textPeso.text = "Peso informado: $peso kg"
            textAltura.text = "Altura informado: $altura m"

            val imc = peso / (altura * altura)

            val resultado = if (imc < 18.5) {
                "Baixo"
            } else if (imc in 18.5..24.9) {
                "Normal"
            } else if (imc in 25.0..29.9) {
                "Sobrepeso"
            } else {
                "Obeso"
            }
            textResultado.text =  resultado
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}