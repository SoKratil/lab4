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
        val result : TextView = findViewById(R.id.result)
        result.setText(daywek(edittext.text.toString()))


    }

    private fun daywek(num : String): String {
        if (num == "1") return "Понедельник"
        else  if (num == "2") return "Вторник"
        else if (num == "3") return "Среда"
        else if (num == "4") return "Четверг"
        else if (num == "5") return "Пятница"
        else if (num == "6") return "Суббота"
        else if (num == "7") return "Воскресенье"
        else  return "Вы ввели не 1-7"

    }

}