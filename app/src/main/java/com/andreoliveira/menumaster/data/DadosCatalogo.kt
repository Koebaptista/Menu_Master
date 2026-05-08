package com.andreoliveira.menumaster.data

import com.andreoliveira.menumaster.model.Carro
import com.andreoliveira.menumaster.R

object DadosCatalogo {

    fun getLista(categoria: String): List<Carro> {

        return when (categoria) {

            "suv" -> listOf(

                Carro(
                    "Jeep Compass",
                    "SUV moderno com design sofisticado, conforto interno e ótimo desempenho urbano.",
                    R.drawable.carro_padrao,
                    185000.0,
                    2023
                ),

                Carro(
                    "Toyota SW4",
                    "SUV robusto com espaço interno amplo e excelente desempenho off-road.",
                    R.drawable.carro_padrao,                    368000.0,
                    2024
                ),

                Carro(
                    "Honda HR-V",
                    "SUV compacto econômico, confortável e ideal para uso diário.",
                    R.drawable.carro_padrao,                    162000.0,
                    2023
                )
            )

            "economicos" -> listOf(

                Carro(
                    "Chevrolet Onix",
                    "Hatch econômico com ótimo consumo de combustível e tecnologia moderna.",
                    R.drawable.carro_padrao,
                    89000.0,
                    2024
                ),

                Carro(
                    "Hyundai HB20",
                    "Compacto confortável, moderno e ideal para uso urbano.",
                    R.drawable.carro_padrao,
                    95000.0,
                    2023
                ),

                Carro(
                    "Renault Kwid",
                    "Modelo compacto econômico com baixo custo de manutenção.",
                    R.drawable.carro_padrao,
                    72000.0,
                    2024
                )
            )

            "esportivos" -> listOf(

                Carro(
                    "Ford Mustang GT",
                    "Esportivo V8 com desempenho extremo e visual agressivo.",
                    R.drawable.carro_padrao,
                    529000.0,
                    2024
                ),

                Carro(
                    "Chevrolet Camaro",
                    "Muscle car icônico com potência elevada e acabamento esportivo.",
                    R.drawable.carro_padrao,
                    515000.0,
                    2023
                ),

                Carro(
                    "Porsche 911",
                    "Esportivo de luxo com aceleração impressionante e tecnologia premium.",
                    R.drawable.carro_padrao,
                    890000.0,
                    2024
                )
            )

            "luxo" -> listOf(

                Carro(
                    "BMW M3",
                    "Sedan esportivo de luxo com alto desempenho e interior refinado.",
                    R.drawable.carro_padrao,
                    650000.0,
                    2024
                ),

                Carro(
                    "Mercedes Classe C",
                    "Modelo sofisticado com conforto premium e tecnologia avançada.",
                    R.drawable.carro_padrao,
                    420000.0,
                    2023
                ),

                Carro(
                    "Audi A5",
                    "Cupê de luxo com design elegante e performance esportiva.",
                    R.drawable.carro_padrao,
                    399000.0,
                    2024
                )
            )

            "eletricos" -> listOf(

                Carro(
                    "Tesla Model S",
                    "Carro elétrico de alta performance com autonomia avançada.",
                    R.drawable.carro_padrao,
                    750000.0,
                    2024
                ),

                Carro(
                    "BYD Dolphin",
                    "Hatch elétrico moderno com excelente custo-benefício.",
                    R.drawable.carro_padrao,
                    185000.0,
                    2024
                ),

                Carro(
                    "Volvo EX30",
                    "SUV elétrico compacto com foco em segurança e sustentabilidade.",
                    R.drawable.carro_padrao,
                    290000.0,
                    2024
                )
            )

            "todos" -> listOf(
                *getLista("suv").toTypedArray(),
                *getLista("economicos").toTypedArray(),
                *getLista("esportivos").toTypedArray(),
                *getLista("luxo").toTypedArray(),
                *getLista("eletricos").toTypedArray()
            )

            else -> emptyList()
        }
    }
}