package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var numero: Double = 0.0
    lateinit var txtNum1: TextView
    lateinit var txtNum2: TextView

    // Operation: 0=None, 1=Plus, 2=Less, 3=Multi, 4=Div
    var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this, "Work", Toast.LENGTH_LONG).show()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Work", Toast.LENGTH_LONG).show()

        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)

        val btnDelete: Button = findViewById(R.id.btnDelete)
        val btnEqual: Button = findViewById(R.id.btnEqual)

        btnEqual.setOnClickListener{
            var numero2: Double = txtNum2.text.toString().toDouble()
            var response: Double = 0.0

            when(operacion) {
                // Sumar
                1 -> response = numero + numero2
                // Restar
                2 -> response = numero - numero2
                // Multiplicar
                3 -> response = numero * numero2
                // Dividir
                4 -> response = numero / numero2
            }

            txtNum2.setText(response.toString())
            txtNum1.setText("")
        }

        btnDelete.setOnClickListener(){
            txtNum1.setText("")
            txtNum2.setText("")
            numero = 0.0
            operacion = 0
        }
    }

    fun pressDigit(view: View) {
        var num2: String = txtNum2.text.toString()

        when(view.id) {
            R.id.btn0 -> txtNum2.setText(num2 + "0")
            R.id.btn1 -> txtNum2.setText(num2 + "1")
            R.id.btn2 -> txtNum2.setText(num2 + "2")
            R.id.btn3 -> txtNum2.setText(num2 + "3")
            R.id.btn4 -> txtNum2.setText(num2 + "4")
            R.id.btn5 -> txtNum2.setText(num2 + "5")
            R.id.btn6 -> txtNum2.setText(num2 + "6")
            R.id.btn7 -> txtNum2.setText(num2 + "7")
            R.id.btn8 -> txtNum2.setText(num2 + "8")
            R.id.btn9 -> txtNum2.setText(num2 + "9")
            R.id.btnDot -> txtNum2.setText(num2 + ".")
        }
    }

    fun mathOperation(view: View) {
        numero = txtNum1.text.toString().toDouble()
        var num2: String = txtNum2.text.toString()
        txtNum2.setText("")
        when(view.id) {
            R.id.btnPlus -> {
                txtNum1.setText(num2 + "+")
                operacion = 1
            }
            R.id.btnLess -> {
                txtNum1.setText(num2 + "-")
                operacion = 2
            }
            R.id.btnMult -> {
                txtNum1.setText(num2 + "x")
                operacion = 3
            }
            R.id.btnDivi -> {
                txtNum1.setText(num2 + "/")
                operacion = 4
            }
        }
    }
}