package com.andreoliveira.menumaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreoliveira.menumaster.R
import com.andreoliveira.menumaster.adapter.PratoAdapter
import com.andreoliveira.menumaster.data.DadosCardapio

class MenuActivity : AppCompatActivity(){

    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        recycler = findViewById(R.id.recyclerPratos)
        recycler.layoutManager = LinearLayoutManager(this)

        carregarCategoria("pratos")

        findViewById<Button>(R.id.btnEntries).setOnClickListener{
            carregarCategoria("entradas")
        }

        findViewById<Button>(R.id.btnDishes).setOnClickListener{
            carregarCategoria("pratos")
        }

        findViewById<Button>(R.id.btnDesserts).setOnClickListener{
            carregarCategoria("sobremesas")
        }

        findViewById<Button>(R.id.btnDrinks).setOnClickListener{
            carregarCategoria("bebidas")
        }

        findViewById<Button>(R.id.btnExtras).setOnClickListener{
            carregarCategoria("extras")
        }

        findViewById<Button>(R.id.btnFavoritos).setOnClickListener{
            startActivity(Intent(this, FavoritosActivity::class.java))
        }
    }

    fun carregarCategoria(cat:String){
        val lista = DadosCardapio.getLista(cat)
        recycler.adapter = PratoAdapter(lista,this)
    }
}