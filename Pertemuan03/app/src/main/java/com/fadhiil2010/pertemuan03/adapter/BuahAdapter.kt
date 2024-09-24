package com.fadhiil2010.pertemuan03.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.fadhiil2010.pertemuan03.CustomImageRecycle
import com.fadhiil2010.pertemuan03.DetailBuahh
import com.fadhiil2010.pertemuan03.DetailPage
import com.fadhiil2010.pertemuan03.ListViewActivity
import com.fadhiil2010.pertemuan03.R
import com.fadhiil2010.pertemuan03.model.ModelBuah

class BuahAdapter (
    val itemList: ArrayList<ModelBuah>,
    private val getActivity: CustomImageRecycle
    ):
        RecyclerView.Adapter<BuahAdapter.ModelViewHolder>(){

    class ModelViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
         var ItemImage : ImageView
         var Itemtext : TextView

        init {
            ItemImage = itemView.findViewById(R.id.gambar) as ImageView
            Itemtext = itemView.findViewById(R.id.nama) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_custome_image, parent, false)
        return ModelViewHolder(nView)
    }

    override fun onBindViewHolder(holder: BuahAdapter.ModelViewHolder, position: Int) {
        holder.ItemImage.setImageResource(itemList[position].image)
        holder.Itemtext.setText(itemList[position].deskrips)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(getActivity, DetailBuahh::class.java)
            intent.putExtra("imageResId", itemList[position].image)  // Mengirim gambar
            intent.putExtra("deskripsi", itemList[position].deskrips)  // Mengirim deskripsi
            getActivity.startActivity(intent)  // Memulai activity detail
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}