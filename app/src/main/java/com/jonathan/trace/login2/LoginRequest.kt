package com.jonathan.trace.login2

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

class LoginRequest(
    userId: String,
    userPw: String,
    listener: Response.Listener<String>
) : StringRequest(Method.POST, URL, listener, null){
    companion object{
        const val URL = "http://${Address.URL}/login.php"
    }
    private val parameters = mutableMapOf<String, String>()
    init{
        parameters["userId"] = userId
        parameters["userPw"] = userPw
    }
    override fun getParams() = parameters
}