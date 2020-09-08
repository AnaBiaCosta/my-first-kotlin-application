package com.example.anabeatrizapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.text.trimmedLength
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculateGrade(componente: View) {

        //"gets"
        val userName = name.text.toString()
        val grade1 =  test_grade_1.text.toString().toInt()
        val grade2 =  test_grade_2.text.toString().toInt()


        //variáveis para validação
        var firstValueIsCorrect = true
        var secondValueIsCorrect = true
        var thirdValueIsCorrect = true
        var anyValueIsNull = false


        //conta
        val result = (( grade1 + grade2 ) / 2).toDouble()


        //validação dos valores
        if ( userName.length < 3) {
            error_1.visibility = View.VISIBLE
            result_text.visibility = View.GONE
            firstValueIsCorrect = false
        } else {
            error_1.visibility = View.GONE
            firstValueIsCorrect = true
        }

        if ( grade1 <= 0 || grade1 > 10 ) {
            error_2.visibility = View.VISIBLE
            result_text.visibility = View.GONE
            secondValueIsCorrect = false
        } else {
            error_2.visibility = View.GONE
            secondValueIsCorrect = true
        }

        if ( grade2 <= 0 || grade2 > 10 ) {
            error_3.visibility = View.VISIBLE
            result_text.visibility = View.GONE
            thirdValueIsCorrect = false
        } else {
            error_3.visibility = View.GONE
            thirdValueIsCorrect = true
        }


        // mostrar mensagem
        if ( anyValueIsNull == false && firstValueIsCorrect && secondValueIsCorrect && thirdValueIsCorrect ) {
            if ( result >= 0 && result <= 4 ) {
                result_text.visibility = View.VISIBLE
                result_text.text = "${  userName }, sua média foi ${result} e infelizmente você foi reprovad(a). A substutiva será realizada dia 16/09, organize sua agenda para estar presente."
                result_text.setTextColor(Color.parseColor("#EB4A40"))
            } else if ( result >= 5 && result <=7 ) {
                result_text.visibility = View.VISIBLE
                result_text.text = "${ userName }, sua média foi ${result}. Parabéns, você foi aprovado(a)! Aproveite as férias para estudar ainda mais! Nos vemos ano que vem :)"
                result_text.setTextColor(Color.parseColor("#9A00C4"))
            } else {
                result_text.visibility = View.VISIBLE
                result_text.text = "${ userName }, sua média foi ${result}! Parabéns, você foi aprovado(a)! Aproveite suas férias com responsabilidade, nos vemos ano que vem :)"
                result_text.setTextColor(Color.parseColor("#1D8A56"))
            }
        }
    }
}