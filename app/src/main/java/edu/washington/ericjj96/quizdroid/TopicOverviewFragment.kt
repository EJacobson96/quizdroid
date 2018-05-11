package edu.washington.ericjj96.quizdroid

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.overview.*

class TopicOverviewFragment: Fragment() {
    private var quizTopic: Topic? = null
    private var listener: OnTopicSelectedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quizTopic = arguments.getSerializable("quizTopic") as Topic

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return inflater!!.inflate(R.layout.overview, container, false)

    }

    override fun onStart() {
        super.onStart()
        overviewDescription.text = this.quizTopic?.desc
        totalQuestions.text = quizTopic?.questions?.size.toString()
        beginButton.setOnClickListener {
            this.startQuiz(this.quizTopic)
        }
        appBarIcon.setOnClickListener{
            listener?.toPreferences()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnTopicSelectedListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun startQuiz(topic: Topic?) {
        listener?.onTopicSelected(topic)
    }

    interface OnTopicSelectedListener {
        fun onTopicSelected(topic: Topic?)
        fun toPreferences()
    }

}