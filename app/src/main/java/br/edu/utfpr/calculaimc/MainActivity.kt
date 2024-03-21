package br.edu.utfpr.calculaimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var etPeso : EditText
    private lateinit var etAltura : EditText
    private lateinit var tvResultado : TextView
    private lateinit var btCalcular : Button
    private lateinit var btLimpar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById<EditText>( R.id.etPeso )
        etAltura = findViewById<EditText>( R.id.etAltura )
        tvResultado = findViewById<TextView>( R.id.tvResultado )
        btCalcular = findViewById<Button>( R.id.btCalcular )
        btLimpar = findViewById<Button>( R.id.btLimpar )

        btCalcular.setOnClickListener{
            btCalcularOnClick()
        }

        btLimpar.setOnClickListener {
            btLimparOnClick()
        }

    } //fim da função onCreate()

    private fun btLimparOnClick() {

    }

    private fun btCalcularOnClick() {
        val peso = etPeso.text.toString().toDouble()
    }
}