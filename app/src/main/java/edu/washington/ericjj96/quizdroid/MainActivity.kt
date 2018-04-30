package edu.washington.ericjj96.quizdroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mathQ1 = Question("What is 2 + 2?", arrayOf("1", "2", "3", "4"), 3)

        val mathTopic = Topic("Math","Simple maths", arrayOf(mathQ1))

        val physicsQ1 = Question("What is acceleration of gravity?", arrayOf("5.5", "5.6", "-7.5", "-9.8"), 3)

        val physicsTopic = Topic("Physics","Basic introductory to physics", arrayOf(physicsQ1))

        val marvel = Question("What Captain America's first name?", arrayOf("Bob", "Joe", "Steve", "Frank"), 2)

        val marvelTopic = Topic("Marvel Super Heroes","Captain America Trivia", arrayOf(marvel))

        val quiz = Quiz(arrayOf(mathTopic, physicsTopic, marvelTopic))

        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = MainAdapter(quiz)
    }
}
