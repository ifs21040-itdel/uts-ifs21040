package com.ifs21040.dinopedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dinoList: ArrayList<Dino>
    private lateinit var dinoAdapter: DinoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inisialisasi dinoList
        dinoList = ArrayList()

        // Mengisi dinoList dengan data Dino
        dinoList.add(Dino(R.drawable.theropoda, "Theropoda"))
        dinoList.add(Dino(R.drawable.ankylosauria, "Ankylosauria"))
        dinoList.add(Dino(R.drawable.ceratopsia, "Ceratopsia"))
        dinoList.add(Dino(R.drawable.hadrosauridae, "Hadrosauridae"))
        dinoList.add(Dino(R.drawable.pterosauria, "Pterosauria"))
        dinoList.add(Dino(R.drawable.saurischia, "Saurischia"))
        dinoList.add(Dino(R.drawable.sauropoda, "Sauropoda"))
        dinoList.add(Dino(R.drawable.triceratops, "Triceratops"))

        // Inisialisasi DinoAdapter setelah dinoList diisi
        dinoAdapter = DinoAdapter(dinoList)
        recyclerView.adapter = dinoAdapter
    }

}