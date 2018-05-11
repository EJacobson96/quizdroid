package edu.washington.ericjj96.quizdroid

import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(App_Bar)

        appBarIcon.setOnClickListener{
            val intent = Intent(this, Preferences::class.java)
            startActivity(intent)
        }

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1)
        }
        var file = File("./sdcard/questions.json")
        val gson = GsonBuilder().create()
        val topicList: Array<Topic> = gson.fromJson(file.reader(), Array<Topic>::class.java)
        if (QuizApp.data.quizTopics.isEmpty()) {
            QuizApp.initData(topicList)
        }
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = MainAdapter(QuizApp.getRepository())
    }
}
