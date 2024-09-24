package com.fadhiil2010.pertemuan03.model

import com.fadhiil2010.pertemuan03.R

data class ModelBuah(
    val image : Int, val deskrips :String
)


object Mocklist{
    fun getModel() : List<ModelBuah>{
        val itemModel1 = ModelBuah(
            R.drawable.apple,
            "Apel",
        )
        val itemModel2 = ModelBuah(
            R.drawable.grapes,
            "Anggur",
        )
        val itemModel3 = ModelBuah(
            R.drawable.orange,
            "Jeruk",
        )
        val itemModel4 = ModelBuah(
            R.drawable.pear,
            "Pear",
        )
        val itemModel5 = ModelBuah(
            R.drawable.strawberry,
            "Strowbery",
        )


        val itemList: ArrayList<ModelBuah> = ArrayList()
        itemList.add(itemModel1)
        itemList.add(itemModel2)
        itemList.add(itemModel3)
        itemList.add(itemModel4)
        itemList.add(itemModel5)

        return itemList
    }
}