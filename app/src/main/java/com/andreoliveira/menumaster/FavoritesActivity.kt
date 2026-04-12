package com.andreoliveira.menumaster

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreoliveira.menumaster.R
import com.andreoliveira.menumaster.adapter.PratoAdapter
import com.andreoliveira.menumaster.data.DadosCardapio
import com.andreoliveira.menumaster.model.Prato

class FavoritosActivity : AppCompatActivity(){

    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        recycler = findViewById(R.id.recyclerFavoritos)
        recycler.layoutManager = LinearLayoutManager(this)

        val lista = carregarFavoritos()

        if(lista.isEmpty()){
            Toast.makeText(this,"Nenhum favorito ainda",Toast.LENGTH_SHORT).show()
        }

        recycler.adapter = PratoAdapter(lista,this)
    }

    fun carregarFavoritos(): List<Prato>{
        val prefs = getSharedPreferences("favoritos", MODE_PRIVATE)

        val todasListas = listOf(
            DadosCardapio.getLista("entradas"),
            DadosCardapio.getLista("pratos"),
            DadosCardapio.getLista("sobremesas"),
            DadosCardapio.getLista("bebidas")
        )

        val favoritos = mutableListOf<Prato>()

        for(lista in todasListas){
            for(prato in lista){
                if(prefs.getBoolean(prato.nome,false)){
                    favoritos.add(prato)
                }
            }
        }

        return favoritos
    }
}