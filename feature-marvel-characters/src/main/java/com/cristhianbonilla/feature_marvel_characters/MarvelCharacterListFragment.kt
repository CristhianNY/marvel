package com.cristhianbonilla.feature_marvel_characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cristhianbonilla.feature_marvel_characters.databinding.FragmentMarvelCharacterListBinding
import com.cristhianbonilla.support.config.fragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarvelCharacterListFragment : Fragment() {

    private val binding by fragmentBinding<FragmentMarvelCharacterListBinding>(R.layout.fragment_marvel_character_list)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.run {
        root
    }
}
