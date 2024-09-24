package com.fadhiil2010.pertemuan03

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HalamaUtama : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_halama_utama)

        val btnPasing = findViewById<Button>(R.id.btnPassingButton)
        val btnListview = findViewById<Button>(R.id.btnListview)
        val btnRv = findViewById<Button>(R.id.btnRv)
        val btnmovie = findViewById<Button>(R.id.btnMovie)
        val btnBuah = findViewById<Button>(R.id.btnBuah)

        val ActButton2 = findViewById<Button>(R.id.btnPassingButton)
        ActButton2.setOnClickListener {
            val Intent = Intent(this, LoginPage::class.java)
            startActivity(Intent)
        }


        btnListview.setOnClickListener {
            val Intent = Intent(this, ListViewActivity::class.java)
            startActivity(Intent)
        }

        btnRv.setOnClickListener {
            val Intent = Intent(this, RecycleViewActivity::class.java)
            startActivity(Intent)
        }

        btnBuah.setOnClickListener {
            val Intent = Intent(this, CustomImageRecycle::class.java)
            startActivity(Intent)
        }

        btnmovie.setOnClickListener {
            val Intent = Intent(this, RecycleViewCardMovie::class.java)
            startActivity(Intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}