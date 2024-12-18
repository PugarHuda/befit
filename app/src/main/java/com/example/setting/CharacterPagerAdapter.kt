package com.example.setting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.setting.R

class CharacterPagerAdapter(private val characterList: List<Character>) :
    RecyclerView.Adapter<CharacterPagerAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterName: TextView = itemView.findViewById(R.id.characterName)
        val characterImage: ImageView = itemView.findViewById(R.id.characterImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        holder.characterName.text = character.name
        holder.characterImage.setImageResource(character.imageResId)
    }

    override fun getItemCount(): Int = characterList.size
}
