package edu.washington.ericjj96.quizdroid

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.questions.*


class QuestionActivity: Fragment() {
    private var quizTopic: Topic? = null
    private var question: Question? = null
    private var listener: OnQuestionSelectedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        quizTopic = arguments.getSerializable("quizTopic") as Topic
        question = quizTopic?.topicQuestions?.get(0)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return inflater!!.inflate(R.layout.questions, container, false)
    }

    override fun onStart() {
        super.onStart()
        submitButton.visibility = View.INVISIBLE
        topic_Question.text = question?.topicQuestion
        option1.text = question?.options?.get(0)
        option2.text = question?.options?.get(1)
        option3.text = question?.options?.get(2)
        option4.text = question?.options?.get(3)

        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, ID ->
            submitButton.visibility = View.VISIBLE
        })

        submitButton.setOnClickListener {
            val id = radioGroup.checkedRadioButtonId
            Log.i("tag", id.toString())
            this.submit(quizTopic, id)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnQuestionSelectedListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun submit(topic: Topic?, userInput: Int?) {
        listener?.onQuestionSelected(topic, userInput)
    }

    interface OnQuestionSelectedListener {
        fun onQuestionSelected(topic: Topic?, userInput: Int?)
    }


}
