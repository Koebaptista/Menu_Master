package com.andreoliveira.menumaster.data

import com.andreoliveira.menumaster.model.Prato
import com.andreoliveira.menumaster.R

object DadosCardapio {

    fun getLista(categoria: String): List<Prato>{
        return when(categoria){
            "entradas" -> listOf(
                Prato("Bruschetta", "Pão com tomate", R.drawable.ic_launcher_foreground),
                Prato("Salada", "Salada fresca", R.drawable.ic_launcher_foreground)
            )
            "pratos" -> listOf(
                Prato("Pizza", "Pizza de pepperoni", R.drawable.ic_launcher_foreground),
                Prato("Hambúrguer", "Artesanal", R.drawable.ic_launcher_foreground),
                Prato("Macarrão", "Bolonhesa", R.drawable.ic_launcher_foreground),
                Prato("Risoto", "Camarão", R.drawable.ic_launcher_foreground),
                Prato("Sushi", "Gourmet", R.drawable.ic_launcher_foreground),
                Prato("Sanduíche", "Natural", R.drawable.ic_launcher_foreground),
                Prato("Feijoada", "Completa", R.drawable.ic_launcher_foreground),
                Prato("Sopa", "De legumes", R.drawable.ic_launcher_foreground),
                Prato("Frango", "Assado", R.drawable.ic_launcher_foreground),
                Prato("Churrasco", "Picanha premium", R.drawable.ic_launcher_foreground),
            )
            "sobremesas" -> listOf(
                Prato("Sorvete", "Especial", R.drawable.ic_launcher_foreground)
            )
            "bebidas" -> listOf(
                Prato("Suco", "Natural", R.drawable.ic_launcher_foreground)
            )
            "extras" -> listOf(
                Prato("Brinde infantil", "Brinquedo para crianças", R.drawable.ic_launcher_foreground)
            )
            else -> emptyList()
        }
    }
}