package com.emresahin.saymyname.characters

import com.emresahin.saymyname.model.Character

data class CharactersUiState(
    val characters: List<Character> = emptyList(),
)
