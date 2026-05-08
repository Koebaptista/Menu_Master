package com.andreoliveira.menumaster

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreoliveira.menumaster.adapter.CarroAdapter
import com.andreoliveira.menumaster.data.DadosCatalogo

class CatalogoActivity : AppCompatActivity(){

    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        recycler = findViewById(R.id.recyclerCarros)
        recycler.layoutManager = LinearLayoutManager(this)

        carregarCategoria("todos")

        findViewById<Button>(R.id.btnSUV).setOnClickListener {
            carregarCategoria("suv")
        }

        findViewById<Button>(R.id.btnEconomicos).setOnClickListener {
            carregarCategoria("economicos")
        }

        findViewById<Button>(R.id.btnEsportivos).setOnClickListener {
            carregarCategoria("esportivos")
        }

        findViewById<Button>(R.id.btnLuxo).setOnClickListener {
            carregarCategoria("luxo")
        }

        findViewById<Button>(R.id.btnEletricos).setOnClickListener {
            carregarCategoria("eletricos")
        }

        findViewById<Button>(R.id.btnFavoritos).setOnClickListener {
            startActivity(Intent(this, FavoritosActivity::class.java))
        }
    }


    override fun onResume() {
        super.onResume()
        carregarCategoria("todos")
    }

    fun carregarCategoria(cat:String){
        val lista = DadosCatalogo.getLista(cat)
        recycler.adapter = CarroAdapter(lista,this)
    }
}