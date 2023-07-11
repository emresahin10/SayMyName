package com.emresahin.saymyname.character_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emresahin.saymyname.data.characters.CharactersRepository
import com.emresahin.saymyname.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val charId: String = CharacterDetailArgs(savedStateHandle).charId

    private val mViewState = MutableStateFlow(CharacterDetailUiState())
    val viewState: StateFlow<CharacterDetailUiState> = mViewState.asStateFlow()

    init {
        fetchCharacterDetail()
    }

    private fun fetchCharacterDetail() = viewModelScope.launch {
        charactersRepository.getCharacter(charId).onSuccess { character ->
            mViewState.update { it.copy(character = character) }
        }
    }
}