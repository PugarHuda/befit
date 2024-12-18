package com.example.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.setting.R
import com.example.setting.Character // Sesuaikan dengan package class Character Anda


class CharacterDialogFragment(private val characterList: List<Character>) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_inventory, container, false)
        val viewPager: ViewPager2 = view.findViewById(R.id.characterViewPager)

        val adapter = CharacterPagerAdapter(characterList)
        viewPager.adapter = adapter

        return view
    }
}
