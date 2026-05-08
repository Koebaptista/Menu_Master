package com.andreoliveira.menumaster.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.andreoliveira.menumaster.R
import com.andreoliveira.menumaster.MainActivity

class InicioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_inicio,
            container,
            false
        )

        view.findViewById<Button>(R.id.btnEntrar)
            .setOnClickListener {

                (activity as MainActivity)
                    .mostrarBottomNavigation()

                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameContainer, CatalogoFragment())
                    .commit()
            }

        return view
    }
}