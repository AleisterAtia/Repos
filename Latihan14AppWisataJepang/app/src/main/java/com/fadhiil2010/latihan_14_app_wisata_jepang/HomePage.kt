package com.fadhiil2010.latihan_14_app_wisata_jepang

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.fadhil2010.latihan_14_app_wisata_jepang.adapter.AdapterGambar


class HomePage : AppCompatActivity() {


    private val imageList = arrayOf(
        R.drawable.osaka,
        R.drawable.oyama,
        R.drawable.tokyo,
        R.drawable.kyoto
    )

    private val title = arrayOf("Osaka", "Bendungan Oyama", "Tokyo", "Kyoto")
    private val location = arrayOf("Lokasi : Osaka,Jepang", "Lokasi : Kota Hita, Prefektur Oita", "Lokasi : Tokyo,Jepang", "Lokasi : Kyoto,Jepang")
    private val tgl = arrayOf(
        "Tgl : 20 - September - 2024",
        "Tgl : 1 - Agustus - 2024",
        "Tgl : 12 - Maret - 2024",
        "Tgl : 17 - Juni - 2024"
    )

    private val des = arrayOf(
        "Osaka adalah salah satu kota terbesar dan paling penting di Jepang, terletak di wilayah Kansai, di pulau utama Honshu. Dikenal sebagai pusat ekonomi dan budaya, Osaka memiliki sejarah panjang dan memainkan peran penting dalam perkembangan Jepang, baik sebagai kota pelabuhan maupun pusat perdagangan.",
        "Patung perunggu tokoh-tokoh utama Attack on Titan berada di kaki Bendungan Oyama, Kota Hita, Prefektur Oita, Jepang. Patung-patung tersebut adalah Eren, Mikasa, dan Armin.",
        "Tokyo adalah ibu kota Jepang dan salah satu kota metropolitan terbesar di dunia. Terkenal dengan gedung pencakar langit, distrik bisnis yang ramai, serta teknologi mutakhir, Tokyo adalah pusat dari kemajuan modern di Jepang. Kota ini memiliki suasana yang dinamis dengan inovasi di setiap sudut.",
        "Kyoto adalah kota bersejarah yang dikenal sebagai pusat budaya tradisional Jepang. Dulunya adalah ibu kota Jepang selama lebih dari seribu tahun, Kyoto kaya akan kuil, taman, dan istana yang menggambarkan masa lalu feodal Jepang."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)

        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter = AdapterGambar(this, imageList, title, location)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, Detail::class.java)
            intent.putExtra("Gambar", imageList[position])
            intent.putExtra("Judul", title[position])
            intent.putExtra("Lokasi", location[position])
            intent.putExtra("tanggal", tgl[position])
            intent.putExtra("Deskripsi", des[position])
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}