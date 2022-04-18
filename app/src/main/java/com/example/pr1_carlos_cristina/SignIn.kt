package com.example.pr1_carlos_cristina

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        findViewById<Button>(R.id.sign_in)?.setOnClickListener{
            val intent: Intent = Intent(this,MenuPatinets::class.java)
            startActivity(intent)
        }
    }

}