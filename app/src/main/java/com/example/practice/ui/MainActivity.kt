package com.example.practice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.practice.R
import com.example.practice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            ActivityMainBinding.inflate(LayoutInflater.from(this), findViewById(android.R.id.content), false)
        setContentView(binding.root)

        val fragment = PokemonFragment.instance()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment)
            .commit()
    }
}