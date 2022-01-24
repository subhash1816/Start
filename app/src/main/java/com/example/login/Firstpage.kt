package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Firstpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstpage)

        val rec= intent.getStringExtra("user")
        val remote = findViewById<TextView>(R.id.message)
        val res="Hii $rec"
        remote.text=res
    }
}