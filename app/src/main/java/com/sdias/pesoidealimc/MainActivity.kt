package com.sdias.pesoidealimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    //ACAO AO CLICAR NO BOTAO CALCULAR
    private fun setListeners(){
        btn_calcular?.setOnClickListener {
            exibirFaixaDePeso()
        }
    }

    //FUNCAO PARA CALCULAR IMC
    private fun calcularIMC(peso: String, altura: String): Float? {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        return if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            imc
        } else {
            null
        }
    }

    //FUNCAO PARA ABRIR NOVA ACTTIVITY
    private fun abrirNovaTelaComResultados(imc: String, faixa: String) {
        val result = Intent(this, SecondActivity::class.java)
        result.putExtra(SecondActivity.IMC_RESULT, imc)
        result.putExtra(SecondActivity.FAIXA_DE_PESO, faixa)
        startActivity(result)
    }

    //FUNCAO PARA EXIBIR FAIXA DE PESO
    private fun exibirFaixaDePeso() {
        val peso = editText_peso?.text.toString()
        val altura = editText_altura?.text.toString()
        val imc = calcularIMC(peso, altura)


        imc?.let {
            val faixa: String = when (it) {
                in 18.5..24.9 -> {
                    "Peso Normal"
                }
                in 25.0..29.9 -> {
                    "Sobrepeso"
                }
                in 30.0..34.9 -> {
                    "Obesidade tipo I"
                }
                in 35.0..39.9 -> {
                    "Obesidade tipo II"
                }
                else -> {
                    if (it < 18.5) {
                        "Abaixo do peso"
                    } else if (it > 40) {
                        "Obesidade tipo III"
                    } else {
                        "Classe indefinida"
                    }

                }

            }

            abrirNovaTelaComResultados("%.2f".format(it), faixa)
        }

    }


}