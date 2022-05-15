package com.example.pr1_carlos_cristina

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val UsuariText: EditText
        UsuariText = findViewById(R.id.editTextTextPersonName)

        val contrasenyaText: EditText
        contrasenyaText = findViewById(R.id.editTextTextPersonName7)

        var usuari:String? = null
        var contrasenya:String? = null


        val ErrorMessage: TextView
        ErrorMessage = findViewById(R.id.ErrorMessage)


        findViewById<Button>(R.id.sign_up)?.setOnClickListener{

            //Escriptura del fitxer Registre.xml
            var preferences: SharedPreferences
            preferences = getSharedPreferences("Registre", Context.MODE_PRIVATE)

            var editor: SharedPreferences.Editor
            editor = preferences.edit()

            usuari = UsuariText.getText().toString()
            contrasenya = contrasenyaText.getText().toString()

            editor.putString("user",usuari)
            editor.putString("password",contrasenya)

            editor.commit()

            val intent: Intent = Intent(this,SignIn::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.sign_in)?.setOnClickListener{

            //Lectura del fitxer Registre.xml
            var preferences: SharedPreferences
            preferences = getSharedPreferences("Registre", Context.MODE_PRIVATE)


            var user: String? = preferences.getString("user","No DATA FOUND")
            var password: String? = preferences.getString("password","No DATA FOUND")

            usuari = UsuariText.getText().toString()
            contrasenya = contrasenyaText.getText().toString()

            if(user.equals(usuari) and password.equals(contrasenya)){
                val intent: Intent = Intent(this,SignIn::class.java)
                startActivity(intent)
            }
            else{
                ErrorMessage.setText("El usuari no ha sigut registrat")
            }


        }

    }

}