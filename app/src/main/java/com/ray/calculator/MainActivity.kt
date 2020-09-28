package com.ray.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun beNumberEvent(view: View) {

        val buSelect = view as Button
        var buClickValue: String = show_number.text.toString()
        if (buClickValue == "0") {
            buClickValue = " "
        }

        newOp = false

        when (buSelect.id) {
            zero.id -> {
                buClickValue += "0"
            }
            one.id -> {
                buClickValue += "1"
            }
            two.id -> {
                buClickValue += "2"
            }
            three.id -> {
                buClickValue += "3"
            }
            four.id -> {
                buClickValue += "4"
            }
            five.id -> {
                buClickValue += "5"
            }
            six.id -> {
                buClickValue += "6"
            }
            seven.id -> {
                buClickValue += "7"
            }
            eight.id -> {
                buClickValue += "8"
            }
            nine.id -> {
                buClickValue += "9"
            }
            dot.id -> {
                if (buClickValue == " ") {
                    buClickValue += "0."
                } else if (buClickValue[buClickValue.length - 1] == '*' || buClickValue[buClickValue.length - 1] == '/'
                    || buClickValue[buClickValue.length - 1] == '+' || buClickValue[buClickValue.length - 1] == '-'
                ) {
                    buClickValue += "0."
                } else {
                    buClickValue += "."
                }
            }
        }
        show_number.setText(buClickValue)
    }

    fun back(view: View) {
        var s = show_number.text.toString()
        if (s.length == 1) {
            s = "0"
        } else if (s.length == 2){
            s = "0"
        }else {
            s = s.substring(0, s.length - 1)
        }
        return show_number.setText(s)
    }

    fun event(view: View) {
        val buSelect = view as Button
        var buClickValue: String = show_number.text.toString()
        if (buClickValue == " ") {
            buClickValue += "0"
        }
        if (buClickValue[buClickValue.length - 1] == '*' || buClickValue[buClickValue.length - 1] == '/'
            || buClickValue[buClickValue.length - 1] == '+' || buClickValue[buClickValue.length - 1] == '-'
        ) {
            buClickValue = buClickValue.dropLast(1)
        } else {
            show_number.setText(calculator(show_number.text.toString()))
            Log.d("dd","show string = ${show_number.text}")
            buClickValue = show_number.text.toString()
        }

        when (buSelect.id) {
            div.id -> {
                buClickValue += "/"
            }
            mul.id -> {
                buClickValue += "*"
            }
            minus.id -> {
                buClickValue += "-"
            }
            plus.id -> {
                buClickValue += "+"
            }
        }
        show_number.setText(buClickValue)
    }

    fun percent(view: View) {
        var buClickValue: String = show_number.text.toString()
        if (buClickValue[buClickValue.length - 1] == '*' || buClickValue[buClickValue.length - 1] == '/'
            || buClickValue[buClickValue.length - 1] == '+' || buClickValue[buClickValue.length - 1] == '-'
        ) {
            buClickValue = buClickValue.dropLast(1)
            buClickValue = (buClickValue.toDouble() / 100).toString()
            show_number.setText(buClickValue)
        } else {
            buClickValue = (buClickValue.toDouble() / 100).toString()
            show_number.setText(buClickValue)
        }
    }

    fun clean(view: View) {
        show_number.setText("0")
    }


    var newOp = true
    fun equal(view: View) {
        var answer: String
        var buClickValue: String = show_number.text.toString()
        if (buClickValue[buClickValue.length - 1] == '*' || buClickValue[buClickValue.length - 1] == '/'
            || buClickValue[buClickValue.length - 1] == '+' || buClickValue[buClickValue.length - 1] == '-'
        ) {
            buClickValue = buClickValue.dropLast(1)
            show_number.setText(buClickValue)
        }
        answer = calculator(show_number.text.toString())
        show_number.setText(answer)
        if (newOp == true) {
            show_number.setText(answer)
        }
        newOp = true
    }

    fun calculator(ex: String): String {
        var num1 = " "
        var num2 = " "
        var answer: Double = 0.0
        if ('*' in ex) {
            var index: Int = ex.indexOf('*')
            num1 = ex.substring(0, index)
            num2 = ex.substring(index + 1)
            answer = num1.toDouble() * num2.toDouble()
            return answer.toString()
        }
        if ('/' in ex) {
            var index: Int = ex.indexOf('/')
            num1 = ex.substring(0, index)
            num2 = ex.substring(index + 1)
            answer = num1.toDouble() / num2.toDouble()
            return answer.toString()
        }
        if ('+' in ex) {
            var index: Int = ex.indexOf('+')
            num1 = ex.substring(0, index)
            num2 = ex.substring(index + 1)
            answer = num1.toDouble() + num2.toDouble()
            return answer.toString()
        }
        if ('-' in ex) {
            var index: Int = ex.indexOf('-')
            num1 = ex.substring(0, index)
            num2 = ex.substring(index + 1)
            answer = num1.toDouble() - num2.toDouble()
            return answer.toString()
        }
        return ex

    }

}


