package com.cristhianbonilla.feature_marvel_characters.character_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cristhianbonilla.domain.characters.model.detail.CharacterModel
import com.cristhianbonilla.feature_marvel_characters.R
import com.cristhianbonilla.feature_marvel_characters.databinding.FragmentCharacterDetailBinding
import com.cristhianbonilla.support.config.fragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {
    private val viewModel by viewModels<CharacterDetailViewModel>()
    private val binding by fragmentBinding<FragmentCharacterDetailBinding>(R.layout.fragment_character_detail)

    private val args: CharacterDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModeEvents()
        viewModel.getCharacterDetailById(args.characterId.orEmpty())
    }

    private fun observeViewModeEvents() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            when (state) {
                is CharacterDetailState.Loading -> Toast.makeText(
                    requireContext(),
                    requireContext().getString(R.string.loading),
                    Toast.LENGTH_LONG
                ).show()
                is CharacterDetailState.ShowCharacterDetail -> loadCharacterInformation(state.characterList)

                is CharacterDetailState.Error -> Toast.makeText(
                    requireContext(),
                    requireContext().getString(R.string.error_getting_marvel_characters),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun loadCharacterInformation(characterList: List<CharacterModel>?) {
        Toast.makeText(requireContext(), characterList.toString(), Toast.LENGTH_LONG).show()
    }
}
