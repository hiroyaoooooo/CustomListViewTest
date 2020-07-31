package com.hiroyaoooooo.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewItems = returnListViewItems()

        var myListView = findViewById<ListView>(R.id.myListView)
        var sentenceTextView = findViewById<TextView>(R.id.sentenceTexitView)

        myListView.adapter = WordCountAdapter(this, listViewItems)
        sentenceTextView.text = "吾輩は猫である。名前はまだない。吾輩はねこ"
    }

    fun returnListViewItems(): Array<Pair<String,Int>>  {
        val array = arrayOf("吾輩","は","猫","で","ある","。","名前","は","まだ","ない","。","吾輩","は","ねこ")
        var countArray = arrayOf<Pair<String,Int>>()
        for (word in array){
            var isAdd = true
            for (i in countArray.indices ) {
                if (countArray[i].first == word) {
                    countArray[i] = Pair(word,countArray[i].second + 1)
                    isAdd = false
                    break
                }
            }
            if (isAdd) {
                countArray += Pair(word,1)
            }
        }
        return countArray
    }
}