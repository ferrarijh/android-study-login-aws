package com.jonathan.trace.login2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONObject
import java.lang.NumberFormatException

class RegisterActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButton = findViewById<TextView>(R.id.registerSubmitButton).setOnClickListener{
            val userId = findViewById<EditText>(R.id.registerIdEdit).text.toString()
            val userPw = findViewById<EditText>(R.id.registerPwEdit).text.toString()
            val userName = findViewById<EditText>(R.id.registerNameEdit).text.toString()
            val userAgeStr = findViewById<EditText>(R.id.registerAgeEdit).text.toString()
            if(userId.isEmpty() || userPw.isEmpty() || userName.isEmpty() || userAgeStr.isEmpty()){
                Toast.makeText(this, "Fields should not be empty. Please try again", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var userAge = 0
            try {
                userAge = userAgeStr.toInt()
            }catch(e: NumberFormatException){
                e.printStackTrace()
                Toast.makeText(this, "Age should be a number!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val responseListener = Response.Listener<String>{
                handleRegisterResponse(it, this)
                finish()
            }
            val registerRequest = RegisterRequest(userId, userPw, userName, userAge, responseListener)
            val q = Volley.newRequestQueue(this)
            q.add(registerRequest)
        }
    }
}

fun handleRegisterResponse(response: String, activity: Activity){
    try{
        val resp = JSONObject(response)
        val isSuccess = resp.getBoolean("success")
        if (isSuccess){
            Toast.makeText(activity, "Welcome! You're successfully registered.", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(activity, "The ID is already registered. Please try different one.", Toast.LENGTH_SHORT).show()
        }
    }catch(e: Exception){
        e.printStackTrace()
        Toast.makeText(activity, "Something went wrong :(", Toast.LENGTH_SHORT).show()
    }
}