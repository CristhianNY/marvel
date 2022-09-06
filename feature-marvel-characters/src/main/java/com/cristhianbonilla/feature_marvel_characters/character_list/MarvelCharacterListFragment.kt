package com.cristhianbonilla.feature_marvel_characters.character_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.cristhianbonilla.domain.characters.model.CharacterModel
import com.cristhianbonilla.feature_marvel_characters.R
import com.cristhianbonilla.feature_marvel_characters.character_list.adapter.CharacterListAdapter
import com.cristhianbonilla.feature_marvel_characters.databinding.FragmentMarvelCharacterListBinding
import com.cristhianbonilla.support.config.fragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MarvelCharacterListFragment : Fragment() {
    private val viewModel by activityViewModels<MarvelCharacterListViewModel>()
    private val binding by fragmentBinding<FragmentMarvelCharacterListBinding>(R.layout.fragment_marvel_character_list)

    private val characterListAdapter = CharacterListAdapter()

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
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.rvCharacterList.apply {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            adapter = characterListAdapter
        }
    }

    private fun observeViewModeEvents() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is MarvelCharacterListState.Loading -> Toast.makeText(
                    requireContext(),
                    requireContext().getString(R.string.loading),
                    Toast.LENGTH_LONG
                ).show()
                is MarvelCharacterListState.ShowMarvelCharacterList -> fillCharacterList(state.characterList)

                is MarvelCharacterListState.Error -> Toast.makeText(
                    requireContext(),
                    requireContext().getString(R.string.error_getting_marvel_characters),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun fillCharacterList(characterList: List<CharacterModel>?) {
        characterListAdapter.submitList(characterList)
    }

    private fun characterClicked(characterModel: CharacterModel) {
        Toast.makeText(requireContext(), characterModel.name, Toast.LENGTH_LONG).show()
    }
}
