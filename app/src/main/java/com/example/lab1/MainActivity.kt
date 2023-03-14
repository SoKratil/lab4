package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    fun clik(view: View)
    {
        val edittext : EditText = findViewById(R.id.addnum)
        val result : TextView = findViewById(R.id.add)
        val result2 : TextView = findViewById(R.id.add2)
        val text = edittext.text.toString().toInt()*edittext.text.toString().toInt()
        result.setText("1/$text")
        result2.setText(math(edittext.text.toString()))


    }

    private fun math(num : String): String
    {
        var sum = 0.0
        if (num == null || !num.all { it.isDigit() })
        {
            return "Ошибка: x должен быть числом."
        }
        else
        {
            for (i in 1..num.toInt())
            {
                sum += 1.0 / (i*i)
            }
            val formattedValue = String.format("%.3f", sum)
            return "Сумма чисел от 1 до 1/$num равна $formattedValue."
        }

    }

}