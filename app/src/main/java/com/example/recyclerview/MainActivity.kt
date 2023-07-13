package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArray : ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val newsImageArray = arrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4
           ,R.drawable.img5,R.drawable.img6)

        val newsHeading = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
        )

        val newsContent = arrayOf(getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content))

        myRecyclerView = findViewById(R.id.recyclerview)

        // to set the layout whether it should be horizontal or vertical
        myRecyclerView.layoutManager = LinearLayoutManager(this)

        newsArray = arrayListOf<News>()

        for (index in newsImageArray.indices){

            val news = News(newsHeading[index] , newsImageArray[index],newsContent[index])
            newsArray.add(news)
        }

        var MyAdapter = myAdapter(newsArray , this)
        myRecyclerView.adapter = MyAdapter

        MyAdapter.setitemclicklistener(object : myAdapter.onitemclicklistener{
            override fun onItemclick(position: Int) {

                var intent = Intent(applicationContext , NewsActivityDetail::class.java)
                intent.putExtra("heading" ,newsArray[position].newsHeading )
                intent.putExtra("image",newsArray[position].newsImage)
                intent.putExtra("newscontent" , newsArray[position].newContent)
                startActivity(intent)
            }

        })

    }
}