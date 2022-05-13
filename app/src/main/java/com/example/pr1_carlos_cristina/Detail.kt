package com.example.pr1_carlos_cristina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var extras: Bundle?= null
        extras = getIntent().getExtras()
        var value: String?=null
        var foto: Int=0
        if(extras!=null){
            value = extras.getString("CLAVE")
            foto = extras.getInt("IMAGEN")
        }

        var texto: TextView
        var imagen: ImageView
        texto = findViewById(R.id.detailTextView)
        imagen = findViewById(R.id.fotoRica)

        texto.setText(value)
        imagen.setImageResource(foto)


    }
}