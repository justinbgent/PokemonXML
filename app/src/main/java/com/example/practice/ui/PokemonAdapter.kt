package com.example.practice.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.ListItemPokemonBinding
import com.example.practice.service.server.model.Pokemon
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class PokemonAdapter() : RecyclerView.Adapter<PokemonAdapter.RecyclerViewHolder>() {

    private lateinit var picasso: Picasso
    var list: ArrayList<Pokemon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding: ListItemPokemonBinding =
            ListItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        How to access an image if it requires an auth token.
//        val client = OkHttpClient()
//        val auth = BearerAuthInterceptor(token)
//        client.interceptors().add(auth)
//        picasso = Picasso.Builder(parent.context).downloader(OkHttp3Downloader(client)).build()
        picasso = Picasso.Builder(parent.context).build()
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        if (list.size > 0 && position != -1 && position < list.size) {
            holder.onBind(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    inner class RecyclerViewHolder(private val binding: ListItemPokemonBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Pokemon) {
            /// On bind, show details in recycler item

            if (item.sprites?.frontSpriteUrl != null) {
                // show progress bar
                picasso.load(item.sprites.frontSpriteUrl)
                    .into(binding.pokemonImage, object : Callback {
                        override fun onSuccess() {
                            // hide progress bar
                        }

                        override fun onError(e: Exception?) {
                            // hide progress bar
                            // display empty image
                        }
                    })
            }

            binding.nameText.text = item.name
            binding.heightText.text = item.height.toString()
            binding.weightText.text = item.weight.toString()
        }
    }
}