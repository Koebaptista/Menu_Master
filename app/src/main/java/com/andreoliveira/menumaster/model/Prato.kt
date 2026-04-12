package com.andreoliveira.menumaster.model

data class Prato(
    val nome: String,
    val descricao: String,
    val imagem: Int,
    var favorito: Boolean = false
)