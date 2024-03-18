package com.ifs21040.dinopedia

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class DinoAdapter(private val dinoList: ArrayList<Dino>) :
    RecyclerView.Adapter<DinoAdapter.DinoViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickListener = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DinoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return DinoViewHolder(view)
    }

    override fun onBindViewHolder(holder: DinoViewHolder, position: Int) {
        val dino = dinoList[position]
        holder.imageView.setImageResource(dino.image)
        holder.textView.text = dino.name
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClicked(dino)
        }
    }

    override fun getItemCount(): Int {
        return dinoList.size
    }

    inner class DinoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.theropodaImage)
        val textView: TextView = itemView.findViewById(R.id.textView4)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Dino)
    }
}
