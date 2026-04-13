package com.andreoliveira.menumaster

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import android.widget.CheckBox
import android.widget.Toast

class DetalhePratoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_prato)

        val nome = intent.getStringExtra("nome")
        val descricao = intent.getStringExtra("descricao")
        val imagem = intent.getIntExtra("imagem", 0)

        val preco = intent.getDoubleExtra("preco", 0.0)
        val pessoas = intent.getIntExtra("pessoas", 1)

        val txtNome = findViewById<TextView>(R.id.txtNomeDetalhe)
        val txtDescricao = findViewById<TextView>(R.id.txtDescricaoDetalhe)
        val img = findViewById<ImageView>(R.id.imgDetalhe)
        val txtPreco = findViewById<TextView>(R.id.txtPrecoDetalhe)
        val txtPessoas = findViewById<TextView>(R.id.txtPessoasDetalhe)

        txtNome.text = nome
        txtDescricao.text = descricao
        img.setImageResource(imagem)

        txtPreco.text = "R$ %.2f".format(preco)

        txtPessoas.text =
            if (pessoas == 1)
                "👤 Serve 1 pessoa"
            else
                "👥 Serve $pessoas pessoas"

        val prefs = getSharedPreferences("favoritos", MODE_PRIVATE)
        val check = findViewById<CheckBox>(R.id.checkFavoritoDetalhe)

        check.isChecked = prefs.getBoolean(nome, false)

        check.setOnCheckedChangeListener { _, isChecked ->

            prefs.edit().putBoolean(nome, isChecked).apply()

            if (isChecked) {
                Toast.makeText(this, "$nome adicionado aos favoritos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "$nome removido dos favoritos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

