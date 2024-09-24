package com.fadhiil2010.pertemuan03.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.fadhiil2010.pertemuan03.DetailBuahh
import com.fadhiil2010.pertemuan03.DetailPage
import com.fadhiil2010.pertemuan03.ListViewActivity
import com.fadhiil2010.pertemuan03.R
import com.fadhiil2010.pertemuan03.RecycleViewCardMovie
import com.fadhiil2010.pertemuan03.model.ModelMovie

class MovieAdapter constructor(
    private val getActivity: RecycleViewCardMovie,
    private val movieList: List<ModelMovie>,
    private val itemClickListener: (Int) -> Unit
        ) :
    RecyclerView.Adapter<MovieAdapter.MyViewHolder>()
{
     class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
         val txtMovie : TextView = itemView.findViewById(R.id.txtMovie)
         val imgMovie : ImageView = itemView.findViewById(R.id.imgMovie)
         val cardView : CardView = itemView.findViewById(R.id.cardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_card, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtMovie.text = movieList[position].title
        holder.imgMovie.setImageResource(movieList[position].image)

//        holder.cardView.setOnClickListener(){
//            Toast.makeText(
//                getActivity, movieList[position].title,
//                Toast.LENGTH_SHORT
//            ).show()

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(getActivity, DetailPage::class.java)
            intent.putExtra("imageResId", movieList[position].image)  // Mengirim gambar
            intent.putExtra("deskripsi", movieList[position].title)  // Mengirim deskripsi
            intent.putExtra("tanggal", movieList[position].tanggal)  // Mengirim gambar
            intent.putExtra("sinopsis", movieList[position].sinopsis)  // Mengirim deskripsi

            getActivity.startActivity(intent)  // Memulai activity detail
        }
        }
    }
