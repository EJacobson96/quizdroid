package edu.washington.ericjj96.quizdroid

import android.app.Application
import android.util.Log


class QuizApp() : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.i("App", "being run correctly.")
    }

    companion object {
        val data = QuizData()

        init {
            val mathQ1 = Quiz("What is 2 + 2?", arrayOf("1", "2", "3", "4"), 3)

            val mathTopic = Topic("Math","Simple maths", arrayOf(mathQ1))

            val physicsQ1 = Quiz("What is acceleration of gravity?", arrayOf("5.5", "5.6", "-7.5", "-9.8"), 3)

            val physicsTopic = Topic("Physics","Basic introductory to physics", arrayOf(physicsQ1))

            val marvel = Quiz("What Captain America's first name?", arrayOf("Bob", "Joe", "Steve", "Frank"), 2)

            val marvelTopic = Topic("Marvel Super Heroes","Captain America Trivia", arrayOf(marvel))

            this.data.add(mathTopic)
            this.data.add(physicsTopic)
            this.data.add(marvelTopic)
        }


        fun getRepository(): QuizData {
            return this.data
        }
    }

}

interface TopicRepository {
    fun add(topic: Topic)
    fun get(): MutableList<Topic>
    fun remove(topic: Topic)
}