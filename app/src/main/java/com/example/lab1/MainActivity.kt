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
        val result2 : TextView = findViewById(R.id.add2)
        result2.setText(countLatinLetters(edittext.text.toString()))

    }

    fun countLatinLetters(inputString: String): String
    {
        var count = 0
        for (char in inputString) {
            if (char in 'a'..'z' || char in 'A'..'Z') {
                count++
            }
        }
        return count.toString()
    }

}