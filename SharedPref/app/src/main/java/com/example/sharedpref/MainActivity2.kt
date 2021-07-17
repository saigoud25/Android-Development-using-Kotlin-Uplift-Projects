package com.example.sharedpref

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    lateinit var emailshow : TextView
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        sharedPreferences = getSharedPreferences("sharedpref", Context.MODE_PRIVATE)

        emailshow = findViewById(R.id.emailshow)
        var loginChecked : Boolean = sharedPreferences.getBoolean("logged", false)
        if (loginChecked)
        {
            var emailText : String? = sharedPreferences.getString("emailId", "No Email")
            emailshow.text = emailText.toString()
        }
        else{
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}