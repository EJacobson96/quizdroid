package edu.washington.ericjj96.quizdroid

import android.annotation.SuppressLint
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.answers.*
import kotlinx.android.synthetic.main.questions.*

class AnswerFragment: Fragment() {
    private var quizTopic: Topic? = null
    private var userInput: String? = null
    private var question: Quiz? = null
    private var correctAnswer: String? = null
    private var correctAnswers: Int? = null
//    private var listener: OnAnswerSelectedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        quizTopic = arguments.getSerializable("quizTopic") as Topic
        userInput = arguments.getString("userInput")
        question = quizTopic?.topicQuestions?.get(0)
        correctAnswer = question?.options!!.get(question!!.answer)
        correctAnswers = 0

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return inflater!!.inflate(R.layout.answers, container, false)
    }

    override fun onStart() {
        super.onStart()

        correct_Answer.text = this.correctAnswer
        user_Answer.text = this.userInput

        if (correctAnswer == this.userInput) {
            correctAnswers = correctAnswers?.plus(1)
        }

        summary.text = "You have $correctAnswers out of 1 correct"

        finishButton.setOnClickListener {
            this.startActivity(android.content.Intent(this.activity, MainActivity::class.java))
        }
    }

//    override fun onAttach(context: Context?) {
//        super.onAttach(context)
//        if (context is OnAnswerSelectedListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }

//    fun finish() {
//
//    }
//
//    interface OnAnswerSelectedListener {
//        fun onAnswerSelected()
//    }

}

