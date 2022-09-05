package com.cristhianbonilla.feature_marvel_characters.character_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.cristhianbonilla.feature_marvel_characters.R
import com.cristhianbonilla.feature_marvel_characters.databinding.FragmentMarvelCharacterListBinding
import com.cristhianbonilla.support.config.fragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarvelCharacterListFragment : Fragment() {
    private val viewModel by activityViewModels<MarvelCharacterListViewModel>()
    private val binding by fragmentBinding<FragmentMarvelCharacterListBinding>(R.layout.fragment_marvel_character_list)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.run {
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCharacterList()
        observeViewModeEvents()
    }

    private fun observeViewModeEvents() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is MarvelCharacterListState.Loading -> Toast.makeText(
                    requireContext(),
                    "Loading",
                    Toast.LENGTH_LONG
                ).show()
                is MarvelCharacterListState.ShowMarvelCharacterList -> Toast.makeText(
                    requireContext(),
                    "llegaron${state.characterList}",
                    Toast.LENGTH_LONG
                ).show()

                is MarvelCharacterListState.Error -> Toast.makeText(
                    requireContext(),
                    "Error",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
