package edu.washington.ericjj96.quizdroid

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.topic_row.view.*


class MainAdapter(val quiz: Quiz): RecyclerView.Adapter<CustomViewHolder>() {

    override fun getItemCount(): Int {
        return quiz.listOfTopics.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        var cellForRow = layoutInflater.inflate(R.layout.topic_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val topicTitle = quiz.quizTopics.get(position)
        holder?.view?.topic_title?.text = topicTitle.topicTitle
        holder.quizTopic = topicTitle
    }
}

class CustomViewHolder(val view: View, var quizTopic: Topic? = null): RecyclerView.ViewHolder(view) {
    init {
        view.setOnClickListener {
            val intent = Intent(view.context, TopicOverviewActivity::class.java)
            intent.putExtra("quizTopic", quizTopic)
            view.context.startActivity(intent)
        }
    }
}
