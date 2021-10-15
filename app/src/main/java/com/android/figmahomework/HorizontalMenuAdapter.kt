package com.android.figmahomework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.figmahomework.databinding.ItemHorizontalMenuBinding

class HorizontalMenuAdapter(private val menuList : ArrayList<MenuItemModel>) : RecyclerView.Adapter<HorizontalMenuAdapter.HorizontalMenuViewHolder>() {

    class HorizontalMenuViewHolder(val itemBinding: ItemHorizontalMenuBinding) :
        RecyclerView.ViewHolder(itemBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalMenuViewHolder {
        val itemBinding = ItemHorizontalMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return HorizontalMenuViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: HorizontalMenuViewHolder, position: Int) {

        //Şirket Adı
        with(holder) {
            itemBinding.btnMenu.text = menuList[position].name
        }




    }

    override fun getItemCount(): Int {
        return menuList.size
    }

}

