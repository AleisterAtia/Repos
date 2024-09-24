package com.fadhiil2010.pertemuan03

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailBuahh : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_buahh)

        val txtDetailBuah = findViewById<TextView>(R.id.txtDetailBuah)
        val imgDetailBuah = findViewById<ImageView>(R.id.imgDetailBuah)

        val detailtext = intent.getStringExtra("deskripsi")
        val imgdetail = intent.getIntExtra("imageResId", 0)

        txtDetailBuah.setText(detailtext)
        imgDetailBuah.setImageResource(imgdetail)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}