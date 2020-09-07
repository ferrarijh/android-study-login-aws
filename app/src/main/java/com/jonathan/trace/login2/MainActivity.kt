package com.jonathan.trace.login2

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val user = intent.getStringExtra("user")
        val userJson = JSONObject(user)
        val welcome = "Welcome, ${userJson.getString("userName")}!"
        welcomeText.text = welcome
    }
}