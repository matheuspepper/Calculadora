package com.example.aposentadoria

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener {
            val idadeTexto = binding.editTextIdade.text.toString()

            if (idadeTexto.isEmpty()) {
                Toast.makeText(this, "Por favor, digite a sua idade", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val idade = idadeTexto.toInt()
            val genero = binding.spinnerGenero.selectedItem.toString()

            val idadeMinima = if (genero.equals("Feminino", ignoreCase = true)) 62 else 65

            val resultado = idadeMinima - idade

            if (resultado <= 0) {
                binding.textViewResultado.text = "Você já deveria estar aposentado."
            } else {
                binding.textViewResultado.text = "Faltam $resultado anos para você se aposentar"
            }
        }
    }
}