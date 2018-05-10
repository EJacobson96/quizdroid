package edu.washington.ericjj96.quizdroid

import java.io.Serializable

class QuizData : TopicRepository {
    val listOfTopics: MutableList<String> = mutableListOf()
    val quizTopics: MutableList<Topic> = mutableListOf()

    constructor()

    override fun add(topic: Topic) {
        this.quizTopics.add(topic)
        listOfTopics.add(topic.topicTitle)
    }

    override fun get(): MutableList<Topic> {
        return this.quizTopics
    }

    override fun remove(topic: Topic) {
        this.quizTopics.remove(topic)
    }
}

class Topic: Serializable {
    val topicTitle: String
    val topicDescription: String
    val topicQuestions: Array<Quiz>

    constructor(title: String, description: String, questions: Array<Quiz>) {
        this.topicTitle = title
        this.topicDescription = description
        this.topicQuestions = questions
    }
}

class Quiz(val topicQuestion: String, val options: Array<String>, val answer:Int): Serializable
