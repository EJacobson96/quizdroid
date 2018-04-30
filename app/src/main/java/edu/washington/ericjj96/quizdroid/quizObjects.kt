package edu.washington.ericjj96.quizdroid

import java.io.Serializable

class Quiz {
    val listOfTopics: MutableList<String> = mutableListOf()
    val quizTopics: Array<Topic>

    constructor(topics: Array<Topic>) {
        this.quizTopics = topics
        for (topic in topics) {
            this.listOfTopics.add(topic.topicTitle)
        }
    }
}

class Topic: Serializable {
    val topicTitle: String
    val topicDescription: String
    val topicQuestions: Array<Question>

    constructor(title: String, description: String, questions: Array<Question>) {
        this.topicTitle = title
        this.topicDescription = description
        this.topicQuestions = questions
    }
}

class Question(val topicQuestion: String, val options: Array<String>, val answer:Int): Serializable
