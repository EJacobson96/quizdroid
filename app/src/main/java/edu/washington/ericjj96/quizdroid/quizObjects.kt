package edu.washington.ericjj96.quizdroid

import java.io.Serializable

class QuizData : TopicRepository {
    val listOfTopics: MutableList<String> = mutableListOf()
    val quizTopics: MutableList<Topic> = mutableListOf()

    constructor()

    override fun add(topic: Topic) {
        this.quizTopics.add(topic)
        listOfTopics.add(topic.title)
    }

    override fun get(): MutableList<Topic> {
        return this.quizTopics
    }

    override fun remove(topic: Topic) {
        this.quizTopics.remove(topic)
    }
}

class Topic: Serializable {
    val title: String
    val desc: String
    val questions: Array<Quiz>

    constructor(title: String, description: String, questions: Array<Quiz>) {
        this.title = title
        this.desc = description
        this.questions = questions
    }
}

class Quiz(val text: String, val answers: Array<String>, val answer:Int): Serializable
