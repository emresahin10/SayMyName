package com.emresahin.saymyname.characters

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharactersScreen(
    state: CharactersUiState,
    onNavigateToCharacterDetail: (characterId: String) -> Unit,
    onNavigateBack: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.fillMaxWidth(),
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(state.characters) { character ->
                CharacterListItem(
                    character = character,
                    onClick = { onNavigateToCharacterDetail(character.charId) }
                )
            }
        }
    }
}