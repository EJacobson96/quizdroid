package edu.washington.ericjj96.quizdroid

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.RadioButton
import kotlinx.android.synthetic.main.app_bar.*

class MultiUseActivity: AppCompatActivity(), TopicOverviewFragment.OnTopicSelectedListener,
        QuestionFragment.OnQuestionSelectedListener {

    override fun onTopicSelected(topic: Topic?) {
        val args = Bundle()
        args.putSerializable("quizTopic", topic)
        val questionFragment = QuestionFragment()
        questionFragment.arguments = args
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.multi_use_activity, questionFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onQuestionSelected(topic: Topic?, userInput: Int?) {
        val args = Bundle()
        args.putSerializable("quizTopic", topic)
        val userAnswerText = findViewById<RadioButton>(userInput as Int).text
        args.putString("userInput", userAnswerText as String)
        val answerFragment = AnswerFragment()
        answerFragment.arguments = args
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.multi_use_activity, answerFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

//    override fun onAnswerSelected() {
//        val args = Bundle()
//        args.putSerializable("quizTopic", topic)
//        val answersFragment = AnswerActivity()
//        answersFragment.arguments = args
//        val transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.multi_use_activity, answersFragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multi_use_activity)

        val overviewFragment = TopicOverviewFragment()
        overviewFragment.arguments = intent.extras
        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.multi_use_activity, overviewFragment)
        transaction.commit()
    }

    override fun toPreferences() {
        val intent = Intent(this, Preferences::class.java)
        startActivity(intent)
    }
}