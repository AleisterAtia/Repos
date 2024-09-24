package com.fadhiil2010.pertemuan03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginPage : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etUsername = findViewById<EditText>(R.id.etUserame)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener() {
            var intent = Intent(this@LoginPage, PageKedua::class.java)
            val nUsername = etUsername.text.toString()
            val nPassword = etPassword.text.toString()
            intent.putExtra("Username", nUsername)
            intent.putExtra("Password", nPassword)
            print("Username :" + nUsername)
            print("Password :" + nPassword)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}