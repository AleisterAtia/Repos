package com.fadhiil2010.pertemuan03

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhiil2010.pertemuan03.adapter.MovieAdapter
import com.fadhiil2010.pertemuan03.model.ModelMovie

class RecycleViewCardMovie : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private var recyclerView : RecyclerView? = null
    private var movieAdapter : MovieAdapter? = null
    private var movieList = mutableListOf<ModelMovie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view_card_movie)

        movieList = ArrayList()

        recyclerView = findViewById(R.id.rvMovieList) as RecyclerView
        
        movieAdapter = MovieAdapter(this@RecycleViewCardMovie, movieList) { position ->
            // Menampilkan dialog gambar detail ketika item di-klik
            showDetailDialog(position)
        }
        
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = movieAdapter



        prepareMovieList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }



    private fun prepareMovieList() {
        var movie = ModelMovie("Avatar", R.drawable.avatar, "29 September 2024", getString(R.string.sinopsis1))
        movieList.add(movie)

        movie = ModelMovie("Batman", R.drawable.batman, "Tanggal Rilis : 29 September 2024", getString(R.string.sinopsis2))
        movieList.add(movie)
        movie = ModelMovie("End Game", R.drawable.end_game, "Tanggal Rilis : 29 September 2024", getString(R.string.sinopsis3))
        movieList.add(movie)
        movie = ModelMovie("Venom", R.drawable.venom, "Tanggal Rilis : 29 September 2024", getString(R.string.sinopsis1))
        movieList.add(movie)
        movie = ModelMovie("Spiderman", R.drawable.spider_man, "Tanggal Rilis : 29 September 2024", getString(R.string.sinopsis2))
        movieList.add(movie)
        movie = ModelMovie("Inception", R.drawable.inception, "Tanggal Rilis : 29 September 2024", getString(R.string.sinopsis3))
        movieList.add(movie)


        movieAdapter!!.notifyDataSetChanged()
    }

    private fun showDetailDialog(position: Int) {
        val intent = Intent(this, DetailPage::class.java) // Pastikan kelas "PhotoDetail" benar
        intent.putExtra("imageResId", movieList[position].image) // Mengirim imageResId ke Activity PhotoDetail
        intent.putExtra("title", movieList[position].title)
        intent.putExtra("tanggal", movieList[position].tanggal) // Mengirim imageResId ke Activity PhotoDetail
        intent.putExtra("sinopsis", movieList[position].sinopsis)
        startActivity(intent)
    }
}