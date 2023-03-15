package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val rightAnswers = intent.getIntExtra("rightAnswers", 0)
        val resultTextView : TextView = findViewById(R.id.end_text)
        resultTextView.text = "Вы ответили правильно на $rightAnswers вопросов"

        val returnButton : Button = findViewById(R.id.return_button)
        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}