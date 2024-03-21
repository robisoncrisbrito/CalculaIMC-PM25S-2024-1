package br.edu.utfpr.calculaimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var etPeso : EditText
    private lateinit var etAltura : EditText
    private lateinit var tvResultado : TextView
    private lateinit var btCalcular : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPeso = findViewById<EditText>( R.id.etPeso )
        etAltura = findViewById<EditText>( R.id.etAltura )
        tvResultado = findViewById<TextView>( R.id.tvResultado )
        btCalcular = findViewById<Button>( R.id.btCalcular )

        btCalcular.setOnClickListener{
            btCalcularOnClick()
        }

    } //fim da função onCreate()


    private fun btCalcularOnClick() {

        if ( etPeso.text.isEmpty() ) {
            etPeso.setError( "Campo peso deve ser preenchido." )
            etPeso.requestFocus()
            return
        }

        if ( etAltura.text.isEmpty() ) {
            etAltura.setError( "Campo altura deve ser preenchido." )
            etAltura.requestFocus()
            return
        }

        val peso = etPeso.text.toString().toDouble()
        val altura = etAltura.text.toString().toDouble()

        val imc = peso / Math.pow(altura, 2.0)

        val df = DecimalFormat ( "0.00" )

        tvResultado.setText( df.format( imc ) )

        Toast.makeText( this, "Sucesso!!!!", Toast.LENGTH_LONG ).show()
    }

    fun btLimparOnClick(view: View) {
        etPeso.setText( "" )
        etAltura.setText( "" )
        tvResultado.setText( "0.00" )
        etPeso.requestFocus()
    }
}