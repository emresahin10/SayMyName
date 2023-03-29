package com.emresahin.saymyname.characters

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
class CharactersViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository,
) : ViewModel() {

    private val mViewState = MutableStateFlow(CharactersUiState())
    val viewState: StateFlow<CharactersUiState> = mViewState.asStateFlow()

    init {
        //fetchCharacters()
    }

    private fun fetchCharacters() = viewModelScope.launch {
        charactersRepository.getCharacters().onSuccess { characters ->
            mViewState.update { it.copy(characters = characters) }
        }
    }
}