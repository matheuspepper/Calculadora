package com.example.aposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val generos = arrayOf("Masculino", "Feminino")

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            generos
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        binding.spinnerGenero.adapter = adapter

        binding.buttonCalcular.setOnClickListener {

            val idadeTexto = binding.editTextIdade.text.toString()

            if (idadeTexto.isEmpty()) {
                binding.editTextIdade.error = "Informe sua idade"
                return@setOnClickListener
            }

            val idade = idadeTexto.toInt()

            val idadeAposentadoria: Int

            if (binding.spinnerGenero.selectedItem.toString() == "Masculino") {
                idadeAposentadoria = 65
            } else {
                idadeAposentadoria = 62
            }

            val resultado = idadeAposentadoria - idade

            if (resultado < 0) {
                binding.textViewResultado.text =
                    getString(R.string.ja_aposentado)
            } else {
                binding.textViewResultado.text =
                    getString(R.string.tempo_restante, resultado)
            }
        }
    }
}