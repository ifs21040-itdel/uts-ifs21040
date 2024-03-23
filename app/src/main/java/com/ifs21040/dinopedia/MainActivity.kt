package com.ifs21040.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21040.dinopedia.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

//    private lateinit var recyclerView: RecyclerView
//    private lateinit var dinoList: ArrayList<Dino>
//    private lateinit var dinoAdapter: DinoAdapter
private lateinit var binding: ActivityMainBinding
    private val dataDino = ArrayList<Dino>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycleView.setHasFixedSize(false)
        dataDino.addAll(getListDino())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListOrganisasi(): ArrayList<Dino> {
        val dataIcon =
            resources.obtainTypedArray(R.array.Icon_Dinos)
        val dataName =
            resources.getStringArray(R.array.Nama_Dino)
        val dataDescription =
            resources.getStringArray(R.array.Deskripsi_Dino)
        val dataKarakteristik =
            resources.getStringArray(R.array.Karakteristik_Dino)
        val dataHabitat =
            resources.getStringArray(R.array.Habitat_Dino)
        val dataMakanan =
            resources.getStringArray(R.array.Makanan_Dino)
        val dataPanjangTinggi =
            resources.getStringArray(R.array.Panjang_Tinggi)
        val dataKelemahan =
            resources.getStringArray(R.array.Kelemahan_Dino)
        val listDino = ArrayList<Dino>()
        for (i in dataName.indices) {
            val dino = Dino(
                dataIcon.getResourceId(i, -1),
                dataName[i],
                dataDescription[i],
                dataKarakteristik[i],
                dataHabitat[i],
                dataMakanan[i],
                dataPanjangTinggi[i],
                dataKelemahan[i]
            )
            listDino.add(dino)
        }
        return listDino
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE
        ) {
            binding.recycleView.layoutManager =
                GridLayoutManager(this, 2)
        } else {
            binding.recycleView.layoutManager =
                LinearLayoutManager(this)
        }
        val DinoAdapter = DinoAdapter(dataDino)
        binding.recycleView.adapter = DinoAdapter
        DinoAdapter.setOnItemClickCallback(object :
            DinoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Dino) {
                showSelectedDino(data)
            }
        })
    }

    private fun showSelectedDino(dino: Dino) {
        val intentWithData = Intent(
            this@MainActivity,
            DetailActivity::class.java
        )
        intentWithData.putExtra(DetailActivity.EXTRA_DINO, dino)
        startActivity(intentWithData)
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.aksi_menu, menu)
//        return true
//    }

}