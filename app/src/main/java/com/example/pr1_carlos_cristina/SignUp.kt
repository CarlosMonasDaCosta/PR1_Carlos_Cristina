package com.example.pr1_carlos_cristina

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        findViewById<Button>(R.id.sign_up)?.setOnClickListener{
            val intent: Intent = Intent(this,SignIn::class.java)
            startActivity(intent)
        }
    }
}