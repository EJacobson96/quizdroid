package edu.washington.ericjj96.quizdroid

import android.app.Application
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import com.google.gson.Gson
import java.io.File


class QuizApp() : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.i("App", "being run correctly.")
    }

    companion object {
        val data = QuizData()

        init {



        }

        fun initData(list: Array<Topic>) {
            for (topic in list) {
                this.data.add(topic)
            }
        }

//            val mathQ1 = Quiz("What is 2 + 2?", arrayOf("1", "2", "3", "4"), 3)
//
//            val mathTopic = Topic("Math","Simple maths", arrayOf(mathQ1))
//
//            val physicsQ1 = Quiz("What is acceleration of gravity?", arrayOf("5.5", "5.6", "-7.5", "-9.8"), 3)
//
//            val physicsTopic = Topic("Physics","Basic introductory to physics", arrayOf(physicsQ1))
//
//            val marvel = Quiz("What Captain America's first name?", arrayOf("Bob", "Joe", "Steve", "Frank"), 2)
//
//            val marvelTopic = Topic("Marvel Super Heroes","Captain America Trivia", arrayOf(marvel))
//
//            this.data.add(mathTopic)
//            this.data.add(physicsTopic)
//            this.data.add(marvelTopic)

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