package br.edu.utfpr.calculaimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var etPeso : EditText
    private lateinit var etAltura : EditText
    private lateinit var tvResultado : TextView
    private lateinit var btCalcular : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e( "onCreate", "mensagem de erro aqui" )
        Log.w( "onCreate", "mensagem de warning aqui" )
        Log.i( "onCreate", "mensagem de info aqui" )
        
        super.onCreate(savedInstanceState)
        println( "passei aqui 2" )
        setContentView(R.layout.activity_main)
        println( "passei aqui 3" )

        etPeso = findViewById( R.id.etPeso )
        etAltura = findViewById( R.id.etAltura )
        tvResultado = findViewById( R.id.tvResultado )
        btCalcular = findViewById( R.id.btCalcular )



        btCalcular.setOnClickListener {
            btCalcularOnClick()
        }



    } //fim da função onCreate()





    private fun btCalcularOnClick() {

        if ( etPeso.text.isEmpty() ) {
            etPeso.error = getString( R.string.erro_peso )
            etPeso.requestFocus()
            return
        }

        if ( etAltura.text.isEmpty() ) {
            etAltura.error = getString( R.string.erro_altura )
            etAltura.requestFocus()
            return
        }

        val peso = etPeso.text.toString().toDouble()
        val altura = etAltura.text.toString().toDouble()



        var imc = 0.0;

        if ( Locale.getDefault().language.equals( "en" ) ) {
            imc = 703 * ( peso / altura.pow( 2.0 ) )
        } else {
            imc = peso / altura.pow(2.0)
        }

        val df = DecimalFormat ( "0.0" )

        tvResultado.text = df.format( imc )

        Toast.makeText( this, getString( R.string.sucesso ), Toast.LENGTH_LONG ).show()
    }

    fun btLimparOnClick(view: View) {
        etPeso.setText( "" )
        etAltura.setText( "" )
        tvResultado.text = getString( R.string.zeros )
        etPeso.requestFocus()
    }
}