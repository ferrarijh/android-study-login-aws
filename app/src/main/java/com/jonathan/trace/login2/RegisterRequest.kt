package com.jonathan.trace.login2

import com.android.volley.Response
import com.android.volley.toolbox.StringRequest

class RegisterRequest(
    userId: String,
    userPw: String,
    userName: String,
    userAge: Int,
    listener: Response.Listener<String>
) : StringRequest(Method.POST, URL, listener, null) {

    companion object{
        const val URL = "http://13.124.217.102/register.php"
    }

    private val parameters : Map<String, String>
    init{
        val test = userId
        parameters = mutableMapOf()
        parameters["userId"] = userId
        parameters["userPw"] = userPw
        parameters["userName"] = userName
        parameters["userAge"] = userAge.toString()
    }

    override fun getParams() = parameters
}