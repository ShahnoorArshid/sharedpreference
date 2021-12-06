package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button=findViewById<Button>(R.id.btnload)
        val button1=findViewById<Button>(R.id.btnsave)
        val editText=findViewById<EditText>(R.id.editTextTextPersonName)
        val editText2=findViewById<EditText>(R.id.etpassword)
        val sharedPref=getSharedPreferences("mypref", MODE_PRIVATE)
        val  editor=sharedPref.edit()
        button1.setOnClickListener {
            val name=editText.text.toString()
            val password=editText2.text.toString()
            editor.apply {
                putString("name",name)
                putString("password",password)
                apply()
            }
        }
        button.setOnClickListener {
            val name=sharedPref.getString("name",null)
            val password=sharedPref.getString("password",null)
        }

    }
}