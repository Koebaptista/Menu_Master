package com.andreoliveira.menumaster.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.andreoliveira.menumaster.model.Prato
import com.andreoliveira.menumaster.R

import android.content.Intent
import com.andreoliveira.menumaster.DetalhePratoActivity

class PratoAdapter(
    private val lista: List<Prato>,
    private val context: Context
) : RecyclerView.Adapter<PratoAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nome: TextView = view.findViewById(R.id.txtNome)
        val descricao: TextView = view.findViewById(R.id.txtDescricao)
        val check: CheckBox = view.findViewById(R.id.checkFavorito)
        val imagem: ImageView = view.findViewById(R.id.imgPrato)
        val preco: TextView = view.findViewById(R.id.txtPreco)
        val pessoas: TextView = view.findViewById(R.id.txtPessoas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_prato,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val prato = lista[position]

        holder.nome.text = prato.nome
        holder.descricao.text = prato.descricao
        holder.preco.text = "R$ %.2f".format(prato.preco)
        holder.imagem.setImageResource(prato.imagem)
        holder.pessoas.text =
            if (prato.pessoas == 1)
                "👤 Serve 1 pessoa"
            else
                "👥 Serve ${prato.pessoas} pessoas"


        holder.itemView.setOnClickListener {

            val intent = Intent(context, DetalhePratoActivity::class.java)

            intent.putExtra("nome", prato.nome)
            intent.putExtra("descricao", prato.descricao)
            intent.putExtra("imagem", prato.imagem)
            intent.putExtra("preco", prato.preco)
            intent.putExtra("pessoas", prato.pessoas)

            context.startActivity(intent)
        }

        val prefs = context.getSharedPreferences("favoritos", Context.MODE_PRIVATE)

        holder.check.isChecked = prefs.getBoolean(prato.nome,false)

        holder.check.setOnCheckedChangeListener{_,isChecked->

            prefs.edit().putBoolean(prato.nome,isChecked).apply()

            if(isChecked){
                Toast.makeText(context, prato.nome + " adicionado aos favoritos", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, prato.nome + " removido dos favoritos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}