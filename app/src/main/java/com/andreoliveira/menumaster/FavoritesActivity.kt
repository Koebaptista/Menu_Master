package com.andreoliveira.menumaster

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreoliveira.menumaster.adapter.CarroAdapter
import com.andreoliveira.menumaster.data.DadosCatalogo
import com.andreoliveira.menumaster.model.Carro

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

        recycler.adapter = CarroAdapter(lista, this) {
            atualizarLista()
        }

        findViewById<Button>(R.id.btnVoltarMenu).setOnClickListener{
            finish()
        }
    }

    fun carregarFavoritos(): List<Carro>{
        val prefs = getSharedPreferences("favoritos", MODE_PRIVATE)

        val todasListas = listOf(
            DadosCatalogo.getLista("suv"),
            DadosCatalogo.getLista("economicos"),
            DadosCatalogo.getLista("esportivos"),
            DadosCatalogo.getLista("luxo"),
            DadosCatalogo.getLista("eletricos")

        )

        val favoritos = mutableListOf<Carro>()

        for(lista in todasListas){
            for(prato in lista){
                if(prefs.getBoolean(prato.nome,false)){
                    favoritos.add(prato)
                }
            }
        }

        return favoritos
    }
    fun atualizarLista() {
        val novaLista = carregarFavoritos()
        recycler.adapter = CarroAdapter(novaLista, this) {
            atualizarLista()
        }
    }
}