package com.example.chapeuseletor1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupCasas)
        val button = findViewById<Button>(R.id.btnSortear)

        button.setOnClickListener {
            val idSelecionado = radioGroup.checkedRadioButtonId

            if (idSelecionado == -1) {
                Toast.makeText(this, "Por favor, selecione uma opção!", Toast.LENGTH_SHORT).show()
            } else {
                val casa = when (idSelecionado) {
                    R.id.radioCoragem -> "Grifinória" // Removido o "!"
                    R.id.radioSabedoria -> "Corvinal"
                    R.id.radioAmbicao -> "Sonserina"
                    R.id.radioLealdade -> "Lufa-Lufa"
                    else -> "Indefinida"
                }

                val intent = Intent(this, ResultadoActivity::class.java)

                intent.putExtra("EXTRA_CASA_NOME", casa)

                startActivity(intent)

                }
        }

    }
}