package com.example.chapeuseletor1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textResultado = findViewById<TextView>(R.id.textResultado)
        val imageBrasao = findViewById<ImageView>(R.id.imageBrasao)

        val nomeCasa = intent.getStringExtra("EXTRA_CASA_NOME")

        textResultado.text = "Você pertence à... $nomeCasa!"

        val idImagem = when (nomeCasa) {
            "Grifinória" -> R.drawable.grifinoria
            "Corvinal" -> R.drawable.corvinal
            "Sonserina" -> R.drawable.sonserina
            "Lufa-Lufa" -> R.drawable.lufalufa
            else -> 0
        }

        if (idImagem != 0) {
            imageBrasao.setImageResource(idImagem)
        }
    }
}