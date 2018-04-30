package edu.washington.ericjj96.quizdroid

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.answers.*
import kotlinx.android.synthetic.main.questions.*


class AnswerActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.answers)

        val quizTopic = intent.getSerializableExtra("quizTopic") as Topic
        val userInput = intent.getStringExtra("userInput")
        val question = quizTopic.topicQuestions.get(0)
        val correctAnswer = question.options.get(question.answer)
        var correctAnswers = 0

        correct_Answer.text = correctAnswer
        user_Answer.text = userInput

        if (correctAnswer == userInput) {
            correctAnswers += 1
        }

        summary.text = "You have $correctAnswers out of 1 correct"

        finishButton.setOnClickListener {
            this.startActivity(android.content.Intent(this, MainActivity::class.java))
        }

    }
}

