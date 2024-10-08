package com.example.numerosprimoskotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        var MitextView : TextView = findViewById(R.id.textView)
        var MiBoton : Button = findViewById(R.id.button)
        val MiEditText : EditText = findViewById(R.id.editTextNumber)





        MiBoton.setOnClickListener {
            var textoBoton = MiBoton.text.toString()
            if (textoBoton.equals("Comprobar")){
                var textoIntroducido = MiEditText.text.toString()
                var textoToInt = textoIntroducido.toInt()

                if (esPrimo(textoToInt)) {
                    MitextView.text = getString(R.string.SiNumeroPrimo)
                } else {
                    MitextView.text = getString(R.string.NoNumeroPrimo)
                }
                MiBoton.text = getString(R.string.reiniciar)
            }

            if (textoBoton.equals("Reiniciar")) {
                MiEditText.text.clear()
                MitextView.text = getString(R.string.INumeroPrimo)
                MiBoton.text = getString(R.string.comprobar)
            }
        }


    }

    private fun esPrimo(numero: Int): Boolean {
        if (numero < 2)
            return false
        for (i in 2 until numero) {
            if (numero % i == 0) {
                return false
            }
        }
        return true
    }

}