package com.fadhiil2010.pertemuan03

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailHewan : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_hewan)

        val tvNamaHewan = findViewById<TextView>(R.id.tvNamaHewan)
        val tvCiriHewan = findViewById<TextView>(R.id.tvCiriHewan)
        val txtTinggi = findViewById<TextView>(R.id.txtTinggi)
        val txtBerat = findViewById<TextView>(R.id.txtBerat)
        val detailhewan = findViewById<ImageView>(R.id.detailhewan)

        // Mendapatkan data yang dikirim dari ListView
        val namaHewan = intent.getStringExtra("namaHewan")
        val ciriHewan = intent.getStringExtra("ciriHewan")
        val tinggiHewan = intent.getStringExtra("tinggiHewan")
        val beratHewan = intent.getStringExtra("beratHewan")
        val gambarHewan = intent.getIntExtra("gambarHewan", 0)

        // Menampilkan data di TextView
        tvNamaHewan.text = namaHewan
        tvCiriHewan.text = ciriHewan
        txtTinggi.text = tinggiHewan
        txtBerat.text = beratHewan


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}