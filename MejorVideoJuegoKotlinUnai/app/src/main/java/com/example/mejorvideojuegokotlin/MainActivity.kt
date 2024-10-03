package com.example.mejorvideojuegokotlin

import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView


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

        val radioGroup = findViewById<RadioGroup>(R.id.zonaElección)
        var textoDf = findViewById<TextView>(R.id.textDefault)
        val checkBox = findViewById<CheckBox>(R.id.encuestaCheck)
        var opinionText = findViewById<CheckBox>(R.id.encuestaCheck)


        radioGroup.setOnCheckedChangeListener() { group, checkedId ->
            //Obtener el radioButton seleccionado
            val rbSeleccionado = findViewById<RadioButton>(checkedId)

            when (checkedId) {
                R.id.juegoIE -> {
                    textoDf.text = getString(R.string.frikiIE)
                }
                R.id.juegoFallout -> {
                    textoDf.text = getString(R.string.frikiFAll)
                }
                R.id.juegoDarkS -> {
                    textoDf.text = getString(R.string.frikiDS)
                }
                R.id.juegoLol -> {
                    textoDf.text = getString(R.string.frikiLOL)
                }
            }
        }

        checkBox.setOnCheckedChangeListener() { group, isChecked ->
            if (isChecked) {
                opinionText.text = getString(R.string.opinionPos)
            } else {
                opinionText.text = getString(R.string.opinionNeg)
            }

        }




    }
}