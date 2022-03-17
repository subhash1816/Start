package com.example.login.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.login.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().run {
            replace(R.id.landing_fragment, Firstpage())
            commit()
        }
    }
}
