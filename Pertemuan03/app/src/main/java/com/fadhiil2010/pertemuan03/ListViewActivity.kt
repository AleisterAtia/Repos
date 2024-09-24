package com.fadhiil2010.pertemuan03

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)

        val lv_item = findViewById<ListView>(R.id.lvHewan)
        val namahewan = listOf("Gajah", "Ular", "harimau","Panda", "Banteng", "Sapi", "Singa")
        val ciriHewan = listOf(
            "Hewan terbesar di darat, memiliki belalai panjang.",
            "Hewan melata yang tidak memiliki kaki, beberapa berbisa.",
            "Hewan besar berbulu tebal, biasanya ditemukan di hutan.",
            "Hewan khas Cina, berbulu hitam dan putih.",
            "Hewan air yang hidup di laut dan sungai.",
            "Hewan ternak yang menghasilkan susu.",
            "Hewan ternak yang sering dijadikan daging kurban."
        )
        val tinggiHewan = listOf(
            "tinggi : 3 - 4 meter",
            "tinggi : 0,5 - 12 meter",
            "tinggi : 1,5 - 3 meter (berdiri tegak)",
            "tinggi : 60 - 90 cm (duduk), 1,2 - 1,8 meter (berdiri)",
            "tinggi : Bervariasi (misalnya paus bisa mencapai 30 meter)",
            "tinggi : 1,2 - 1,5 meter",
            "tinggi : 50 - 60 cm"
        )
        val beratHewan = listOf(
            "berat : 2.700 - 6.000 kg",
            "berat : 0,5 - 250 kg",
            "berat : 80 - 600 kg",
            "berat : 70 - 160 kg",
            "berat : Bervariasi (misalnya paus bisa mencapai 180.000 kg)",
            "berat : 400 - 1.000 kg",
            "berat : 20 - 140 kg"
        )

        lv_item.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namahewan)


        lv_item.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Anda Memilih : ${namahewan[position]}",
                Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DetailHewan::class.java)


            intent.putExtra("namaHewan", namahewan[position])
            intent.putExtra("ciriHewan", ciriHewan[position])
            intent.putExtra("tinggiHewan", tinggiHewan[position])
            intent.putExtra("beratHewan", beratHewan[position])

            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}