package com.fadhiil2010.pertemuan03

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhiil2010.pertemuan03.adapter.BukuAdapter
import com.fadhiil2010.pertemuan03.model.ModelBuku

class RecycleViewActivity : AppCompatActivity() {

    private lateinit var rv_buku : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)

        rv_buku = findViewById(R.id.rv_buku)
        //ini kita bikin array data
        val listBuku = listOf(
            ModelBuku(title = "Buku Android Kotlin5 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Android Kotlin5 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Android Kotlin5 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "Buku Android Kotlin5 2024", penulis = "Rizki Syaputra"),
            ModelBuku(title = "To Kill a Mockingbird", penulis = "Harper Lee"),
        )
        val nBukuAdapter = BukuAdapter(listBuku)
        rv_buku.apply {
            layoutManager = LinearLayoutManager(this@RecycleViewActivity)
            adapter = nBukuAdapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}