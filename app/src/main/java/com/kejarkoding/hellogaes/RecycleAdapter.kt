package com.kejarkoding.hellogaes

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

class RecycleAdapter(private val context: Context, private val items: List<Item>,
    private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecycleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(items: Item , listener: (Item) -> Unit) {
            itemView.name.text = items.name
            Glide.with(itemView.context).load(items.image).into(itemView.image)
            listener(items)
        }
    }

}