package com.example.pr1_carlos_cristina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.view.View
import android.widget.Button
import android.widget.EditText




class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        
        findViewById<Button>(R.id.sign_up)?.setOnClickListener{
            val intent: Intent = Intent(this,SignIn::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.sign_in)?.setOnClickListener{
            val intent: Intent = Intent(this,SignIn::class.java)
            startActivity(intent)
        }

    }

}