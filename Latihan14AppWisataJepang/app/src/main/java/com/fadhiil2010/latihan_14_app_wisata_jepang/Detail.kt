package com.fadhiil2010.latihan_14_app_wisata_jepang

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val ImagesResId = intent.getIntExtra("Gambar", 0)
        val title = intent.getStringExtra("Judul")
        val lokasi = intent.getStringExtra("Lokasi")
        val tgl = intent.getStringExtra("tanggal")
        val dec = intent.getStringExtra("Deskripsi")

        val imageView = findViewById<ImageView>(R.id.img)
        val a = findViewById<TextView>(R.id.tvJudl)
        val b = findViewById<TextView>(R.id.tvLokasi)
        val c = findViewById<TextView>(R.id.tvTanggal)
        val d = findViewById<TextView>(R.id.TvDesc)
        imageView.setImageResource(ImagesResId)
        a.setText(title)
        b.setText(lokasi)
        c.setText(tgl)
        d.setText(dec)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}