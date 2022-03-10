package com.example.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       supportFragmentManager.beginTransaction().run {
            replace(R.id.F1, Firstpage())

            commit()
        }


        }
    }
