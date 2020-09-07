package com.jonathan.trace.login2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_const)

        val idText = findViewById<TextView>(R.id.idText)
        val pwText = findViewById<TextView>(R.id.pwText)

        val loginBtn = findViewById<Button>(R.id.loginButton).setOnClickListener{
            val id = idText.text.toString()
            val pw = pwText.text.toString()

            val responseListener = Response.Listener<String>{
                handleLoginResponse(it, this)
            }
            val loginRequest = LoginRequest(id, pw, responseListener)
            val q = Volley.newRequestQueue(this)
            q.add(loginRequest)
        }
        val registerBtn = findViewById<TextView>(R.id.registerText).setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}

fun handleLoginResponse(response: String, activity: Activity){
    try{
        val jsonResponse = JSONObject(response)
        if(jsonResponse.getBoolean("success")){
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("user", response)
            activity.startActivity(intent)
        }else{
            Toast.makeText(activity, "Login failed. Please check ID and password.", Toast.LENGTH_SHORT).show()
        }
    }catch(e: Exception){
        e.printStackTrace()
        Toast.makeText(activity, "Something went wrong :(", Toast.LENGTH_SHORT).show()
    }
}