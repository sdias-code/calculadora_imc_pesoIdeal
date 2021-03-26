package com.sdias.pesoidealimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setListeners()
    }

    private fun setListeners(){
        btn_voltar?.setOnClickListener {
            onBackPressed()
            //retorna para a tela anterior
        }

        //exibe os valores passados pela tela anterior
        result_imc?.text = intent.getStringExtra(IMC_RESULT)
        result_tipo_peso?.text = intent.getStringExtra(FAIXA_DE_PESO)
    }

    companion object{
        const val FAIXA_DE_PESO = "Peso"
        const val IMC_RESULT = "IMC"
    }
}