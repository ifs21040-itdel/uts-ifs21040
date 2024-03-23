package com.ifs21040.dinopedia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21040.dinopedia.databinding.dinolayoutBinding



class DinoAdapter(private val listDino: ArrayList<Dino>) :
    RecyclerView.Adapter<DinoAdapter.DinoViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DinoViewHolder {
        val binding = dinolayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DinoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DinoViewHolder, position: Int) {
        val dino = listDino[position]
        holder.bind(dino)
    }

    override fun getItemCount(): Int {
        return listDino.size
    }

    inner class DinoViewHolder(private val binding: ItemDinoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dino: Dino) {
            binding.apply {
                itemDino.setImageResource(dino.icon)
                tvItemOrg.text = dino.name
                root.setOnClickListener {
                    onItemClickCallback.onItemClicked(dino)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Dino)
    }
}
