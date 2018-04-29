package edu.washington.ericjj96.quizdroid

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.overview.*

class TopicOverviewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.overview)

        val quizTopic = intent.getSerializableExtra("quizTopic") as Topic
        overviewDescription.text = quizTopic.topicDescription
        totalQuestions.text = quizTopic.topicQuestions.size.toString()

        beginButton.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("quizTopic", quizTopic)
            this.startActivity(intent)
        }
    }




}