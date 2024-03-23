package com.ifs21040.dinopedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.os.Build
import android.view.LayoutInflater;
import com.ifs21040.dinopedia.databinding.ActivityDetailBinding
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var dino: Dino? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dino = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            intent.getParcelableExtra(EXTRA_DINO)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DINO) as Dino?
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            if (dino != null) {
                title = "Dino ${dino!!.name}"
                loadData(dino!!)
            } else {
                finish()
            }
        }
    }

    private fun loadData(dino:Dino){
        binding.dinoIcon.setImageResource(dino.icon)
        binding.namadino.text=dino.name
        binding.detaildesc.text=dino.description
        binding.detailchar.text=dino.characteristic
        binding.detailhab.text=dino.habit
        binding.detailmmakanan.text=dino.food
        binding.detailpanjangtinggi.text=dino.longheight
        binding.detailkelemahan.text=dino.weakness
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_DINO = "extra_dino"
    }



}