package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<Button>(R.id.Login)
        val user = findViewById<EditText>(R.id.userinput)
        val pass = findViewById<EditText>(R.id.Passinput)
        login.setOnClickListener()
        {
            // displaying a toast message
            val username = user.text.toString()
            val password = pass.text.toString()
            if(username.isBlank() || password.isBlank()) {
                Toast.makeText(this@MainActivity, "fill the required fields", Toast.LENGTH_LONG).show()
            }
           else {
                Intent(this@MainActivity, Firstpage::class.java).also {
                    it.putExtra("user", username)
                    startActivity(it)
                }
            }


        }


    }
}