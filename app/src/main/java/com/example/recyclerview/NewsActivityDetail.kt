package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsActivityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val heading = intent.getStringExtra("heading")
        val ImageId = intent.getIntExtra("image",R.drawable.img1)
        val newsContent = intent.getStringExtra("newscontent")

        val Heading = findViewById<TextView>(R.id.Textheading)
        val HeadingImage = findViewById<ImageView>(R.id.imageView)
        val Newscontent = findViewById<TextView>(R.id.newscontent)

        Heading.text = heading
        Newscontent.text = newsContent
        HeadingImage.setImageResource(ImageId)



    }
}