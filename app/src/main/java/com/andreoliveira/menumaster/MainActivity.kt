package com.andreoliveira.menumaster

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.andreoliveira.menumaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDiscover.setOnClickListener {
            val intent = Intent(this, CatalogoActivity::class.java)
            startActivity(intent)
        }
    }
}