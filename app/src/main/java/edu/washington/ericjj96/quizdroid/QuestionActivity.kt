package edu.washington.ericjj96.quizdroid

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.overview.*
import kotlinx.android.synthetic.main.questions.*


class QuestionActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.questions)

        submitButton.visibility = View.INVISIBLE
        val quizTopic = intent.getSerializableExtra("quizTopic") as Topic
        val question = quizTopic.topicQuestions.get(0)
        topic_Question.text = question.topicQuestion
        option1.text = question.options.get(0)
        option2.text = question.options.get(1)
        option3.text = question.options.get(2)
        option4.text = question.options.get(3)

        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, ID ->
            submitButton.visibility = View.VISIBLE
        })

        submitButton.setOnClickListener {
            val currID = radioGroup.checkedRadioButtonId
            val radioButtonChecked = findViewById<RadioButton>(currID)
            val intent = Intent(this, AnswerActivity::class.java)
            intent.putExtra("quizTopic", quizTopic)
            intent.putExtra("userInput", radioButtonChecked.text)
            this.startActivity(intent)
        }
    }
}
