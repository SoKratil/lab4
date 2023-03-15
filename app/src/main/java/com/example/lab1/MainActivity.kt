package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var endButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_1
                , true),
        Question(R.string.question_2,
            true),
        Question(R.string.question_3,
            false),
        Question(R.string.question_4,
            true),
        Question(R.string.question_5
            , false),
        Question(R.string.question_6,
            true),
        Question(R.string.question_7,
            true),
        Question(R.string.question_8,
            false),
        Question(R.string.question_9,
            false),
        Question(R.string.question_10,
            false)

    )
    private var currentIndex = 0
    private var rightanwser = 0

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)

        // Сохраняем текущий индекс вопроса
        savedInstanceState.putInt("currentIndex", currentIndex)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            // Восстанавливаем текущий индекс вопроса
            currentIndex = savedInstanceState.getInt("currentIndex", 0)
        }
        trueButton= findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton= findViewById(R.id.next_button)
        questionTextView= findViewById(R.id.question_text)
        endButton = findViewById(R.id.end_button)
        endButton.visibility = View.INVISIBLE
        trueButton.setOnClickListener { view: View ->


            checkAnswer(true)

        }
        falseButton.setOnClickListener { view: View ->


            checkAnswer(false)
        }
        nextButton.setOnClickListener {

            currentIndex = (currentIndex + 1) %
                    questionBank.size
            val questionTextResId =
                questionBank[currentIndex].textResId
            questionTextView.setText(questionTextResId)
            updateQuestion()


        }
        endButton.setOnClickListener {

            val resultIntent = Intent(this, MainActivity2::class.java)
            resultIntent.putExtra("rightAnswers", rightanwser)
            startActivity(resultIntent)


        }

        val questionTextResId =
            questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
        updateQuestion()



    }
    private fun updateQuestion() {
        val questionTextResId =
            questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
        if (currentIndex == questionBank.size - 1)
        {

            nextButton.visibility = View.INVISIBLE
            endButton.visibility = View.VISIBLE
        }
        else
        {

            nextButton.visibility = View.VISIBLE
        }
        trueButton.visibility = View.VISIBLE
        falseButton.visibility = View.VISIBLE
    }

    private fun checkAnswer(userAnswer:
                            Boolean) {
        val correctAnswer =
            questionBank[currentIndex].answer
        if (userAnswer ==
            correctAnswer)
            rightanwser++
        val messageResId = if (userAnswer ==
            correctAnswer) {
            R.string.correct_toast

        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId,
            Toast.LENGTH_SHORT)
            .show()
        if (currentIndex == questionBank.size - 1) {

            nextButton.visibility = View.INVISIBLE
            endButton.visibility = View.VISIBLE
        } else {

            nextButton.visibility = View.VISIBLE
        }
        trueButton.visibility = View.INVISIBLE
        falseButton.visibility = View.INVISIBLE
    }




}