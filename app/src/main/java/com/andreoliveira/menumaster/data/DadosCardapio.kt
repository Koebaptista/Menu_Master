package com.andreoliveira.menumaster.data

import com.andreoliveira.menumaster.model.Prato
import com.andreoliveira.menumaster.R

object DadosCardapio {

    fun getLista(categoria: String): List<Prato>{
        return when(categoria){

            "entradas" -> listOf(
                Prato(
                    "Bruschetta",
                    "Pão italiano crocante com tomate fresco, manjericão e azeite de oliva",
                    R.drawable.brusqueta,
                    18.90,
                    1
                ),
                Prato(
                    "Salada",
                    "Mix de folhas frescas com tomate, cenoura ralada e molho especial da casa",
                    R.drawable.salada,
                    15.50,
                    1
                )
            )

            "pratos" -> listOf(
                Prato(
                    "Pizza",
                    "Pizza de pepperoni com queijo derretido, molho especial e massa artesanal crocante",
                    R.drawable.pizza,
                    39.90,
                    2
                ),
                Prato(
                    "Hambúrguer",
                    "Hambúrguer artesanal com carne suculenta, queijo cheddar, alface e pão brioche",
                    R.drawable.hamburguer,
                    29.90,
                    1
                ),
                Prato(
                    "Macarrão",
                    "Macarrão ao molho bolonhesa com carne moída temperada e queijo parmesão",
                    R.drawable.macarrao,
                    27.50,
                    2
                ),
                Prato(
                    "Risoto",
                    "Risoto cremoso de camarão com toque de limão siciliano",
                    R.drawable.risoto,
                    42.00,
                    2
                ),
                Prato(
                    "Sushi",
                    "Seleção de sushi gourmet com ingredientes frescos e preparo artesanal",
                    R.drawable.sushi,
                    49.90,
                    2
                ),
                Prato(
                    "Sanduíche",
                    "Sanduíche natural com peito de frango, alface, tomate e pão integral",
                    R.drawable.sanduiche,
                    19.90,
                    1
                ),
                Prato(
                    "Feijoada",
                    "Tradicional feijoada completa com carnes selecionadas e acompanhamentos",
                    R.drawable.feijoada,
                    34.90,
                    3
                ),
                Prato(
                    "Sopa",
                    "Sopa de legumes caseira, leve e nutritiva",
                    R.drawable.sopa,
                    16.00,
                    1
                ),
                Prato(
                    "Frango",
                    "Frango assado dourado com tempero especial da casa",
                    R.drawable.frango,
                    25.90,
                    2
                ),
                Prato(
                    "Churrasco",
                    "Picanha premium grelhada acompanhada de farofa e vinagrete",
                    R.drawable.churrasco,
                    59.90,
                    3
                )
            )

            "sobremesas" -> listOf(
                Prato(
                    "Sorvete",
                    "Sorvete cremoso com sabores variados e cobertura especial",
                    R.drawable.sorvete,
                    12.90,
                    1
                )
            )

            "bebidas" -> listOf(
                Prato(
                    "Suco",
                    "Suco natural feito com frutas frescas, sem conservantes",
                    R.drawable.suco,
                    9.90,
                    1
                )
            )

            "extras" -> listOf(
                Prato(
                    "Brinde infantil",
                    "Brinquedo surpresa especial para crianças",
                    R.drawable.brinquedo,
                    0.00,
                    1
                )
            )

            else -> emptyList()
        }
    }
}