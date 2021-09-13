package com.example.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //O override é para executar o onCreate da classe MainActivity, e não da classe AppCompatActivity.
    override fun onCreate(savedInstanceState: Bundle?) {

        //O super quer dizer acima, ou seja, esse onCreate é da classe AppCompatAcitivity.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Diferença do val pra var é que val cria constante, e o var cria variaveis.
        //Criando as instancias das views para que possam ser manipuladas no Kotlin;
        val editTextPeso = findViewById<EditText>(R.id.edit_peso)
        val editTextAltura = findViewById<EditText>(R.id.edit_altura)
        val buttonCalcular =findViewById<Button>(R.id.button_calcular)
        val textViewResultado = findViewById<TextView>(R.id.text_view__resultado)

        //Adicionar um ouvinte de click no botão
        buttonCalcular.setOnClickListener {

            if(editTextPeso.text.isEmpty()){
                editTextPeso.error = "Peso é obrigatório!"
            } else if (editTextAltura.text.isEmpty()){
                editTextAltura.error = "Altura é obrigatório!"
            }else{
                
                val peso = editTextPeso.text.toString().toInt()
                val altura = editTextAltura.text.toString().toDouble()

                val imc = peso/(altura * altura)

                //%.1f  =  A % representa qualquer coisa, e 1f seria: 1Float(nesse caso uma casa decimal)
                textViewResultado.text = String.format("%.1f", imc)
            }

        }

    }
}