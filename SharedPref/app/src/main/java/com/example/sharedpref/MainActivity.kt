package com.example.sharedpref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.sharedpref.R.id.*

class MainActivity : AppCompatActivity() {
    lateinit var email : EditText
    lateinit var password : EditText
    lateinit var login : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = findViewById(R.id.login)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

        lateinit var sharedPreferences: SharedPreferences

        sharedPreferences = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)
        var checkLogin :Boolean  = sharedPreferences.getBoolean("logged", false)

        if (checkLogin){
            var intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        else
        {
            Toast.makeText(this, "Login Screen", Toast.LENGTH_SHORT).show()
        }

        login.setOnClickListener {
            var EmailText = email.text.toString()
            var PassText = password.text.toString()
            sharedPreferences.edit().putString("emailId", EmailText).apply()
            sharedPreferences.edit().putBoolean("logged", true).apply()

            var intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}