package com.andreoliveira.menumaster.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andreoliveira.menumaster.R
import com.andreoliveira.menumaster.adapter.CarroAdapter
import com.andreoliveira.menumaster.data.DadosCatalogo

class CatalogoFragment : Fragment() {

    lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_catalogo,
            container,
            false
        )

        recycler = view.findViewById(R.id.recyclerCarros)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        carregarCategoria("todos")

        view.findViewById<Button>(R.id.btnSUV).setOnClickListener {
            carregarCategoria("suv")
        }

        view.findViewById<Button>(R.id.btnEconomicos).setOnClickListener {
            carregarCategoria("economicos")
        }

        view.findViewById<Button>(R.id.btnEsportivos).setOnClickListener {
            carregarCategoria("esportivos")
        }

        view.findViewById<Button>(R.id.btnLuxo).setOnClickListener {
            carregarCategoria("luxo")
        }

        view.findViewById<Button>(R.id.btnEletricos).setOnClickListener {
            carregarCategoria("eletricos")
        }

        return view
    }

    fun carregarCategoria(cat: String){

        val lista = DadosCatalogo.getLista(cat)

        recycler.adapter = CarroAdapter(
            lista,
            requireContext()
        )
    }
}