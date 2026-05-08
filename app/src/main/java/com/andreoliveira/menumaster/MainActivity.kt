package com.andreoliveira.menumaster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.andreoliveira.menumaster.databinding.ActivityMainBinding
import com.andreoliveira.menumaster.fragments.CatalogoFragment
import com.andreoliveira.menumaster.fragments.FavoritosFragment
import com.andreoliveira.menumaster.fragments.SobreFragment
import com.andreoliveira.menumaster.fragments.InicioFragment
import android.view.View
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        substituirFragment(InicioFragment())
        binding.bottomNavigation.visibility = View.GONE

        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){

                R.id.menu_catalogo -> {
                    substituirFragment(CatalogoFragment())
                }

                R.id.menu_favoritos -> {
                    substituirFragment(FavoritosFragment())
                }

                R.id.menu_sobre -> {
                    substituirFragment(SobreFragment())
                }
            }

            true
        }
    }

    fun substituirFragment(fragment: Fragment){

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }

    fun mostrarBottomNavigation(){
        binding.bottomNavigation.visibility = View.VISIBLE
    }

    fun esconderBottomNavigation(){
        binding.bottomNavigation.visibility = View.GONE
    }
}