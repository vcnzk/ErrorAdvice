package com.example.ErrorAdvice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start = findViewById<Button>(R.id.btn_start)
        val btn_clr = findViewById<Button>(R.id.btn_clr)
        var textView = findViewById<TextView>(R.id.textView)
        var rg = findViewById<RadioGroup>(R.id.radioGroup)
        var editText = findViewById<EditText>(R.id.editText)

        val whatDo: List<String> = listOf("Полежать на диване...", "Посмотреть фильм!", "Выпить кофе!", "Налить чай!", "Лечь спать!", "Учиться?", "Сделать ДЗ!", "Почитать учебник!", "Поиграть на компьютере!", "Почитать?", "На прогулку!")

        val list_01: List<String> = listOf("0", "1")
        val list_yn: List<String> = listOf("ДА", "НЕТ")
        val list_cb: List<String> = listOf("1", "2", "3", "4", "5", "6")
        var rnd_num: Int = 10
        var rnd_num2 = 1
        var operator = ""
        var list_oper: List<String> = listOf("-", "+")


        var chk_rb: String = "0"


        rg.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.rd_But_01 -> {
                    chk_rb = "01"
                }
                R.id.rd_But_yn -> {
                    chk_rb = "yn"
                }
                R.id.rd_But_cb -> {
                    chk_rb = "cb"
                }
                R.id.rd_But_count -> {
                    chk_rb = "cnt"
                }
                R.id.rd_But_rnd -> {
                    chk_rb = "rnd"
                }
            }
        }

        btn_start.setOnClickListener {v:View->
            when (chk_rb) {
                "0" -> {
                    textView.setText(whatDo.random())
                }
                "01" -> {
                    textView.setText(list_01.random())
                }
                "yn" -> {
                    textView.setText(list_yn.random())
                }
                "cb" -> {
                    textView.setText(list_cb.random())
                }
                "cnt" -> {
                    operator = list_oper.random()
                    if (operator == "+") {
                        rnd_num = (1..editText.text.toString().toInt()).random()
                        rnd_num2 = (1..(10-(editText.text.toString().toInt()-1))).random()
                        textView.text = "$rnd_num + $rnd_num2"
                    } else {
                        rnd_num = (1..editText.text.toString().toInt()).random()
                        rnd_num2 = (1..editText.text.toString().toInt()).random()
                        textView.text = if (rnd_num > rnd_num2) {"$rnd_num - $rnd_num2"}
                        else {"$rnd_num2 - $rnd_num"}
                    }
                }
                "rnd" -> {
                    rnd_num = editText.text.toString().toInt()
                    textView.setText((0..rnd_num).random().toString())
                }
            }
        }

        btn_clr.setOnClickListener {
            rg.clearCheck()
            chk_rb = "0"
            editText.setText("10")
            textView.setText("")
            rnd_num = 10
        }
    }
}











