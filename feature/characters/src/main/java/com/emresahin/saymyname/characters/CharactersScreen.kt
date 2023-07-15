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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emresahin.saymyname.model.Character

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharactersScreen(
    state: CharactersUiState,
    onNavigateToCharacterDetail: (characterId: String) -> Unit,
    onNavigateToQuotes: () -> Unit,
    onNavigateBack: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { onNavigateToQuotes() }) {
            Text(text = "Go to Quotes")
        }
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

@Preview(showBackground = true)
@Composable
private fun CharactersScreenPreview() {
    val characterList = List(5) {
        Character(
            charId = it.toString(),
            name = "Walter White",
            birthday = "09-07-1958",
            img = "https://www.gstatic.com/tv/thumb/persons/532529/532529_v9_ba.jpg",
            status = "Presumed dead",
            nickname = "Heisenberg",
            portrayed = "Bryan Cranston",
            category = "Breaking Bad",
        )
    }
    CharactersScreen(
        state = CharactersUiState(characters = characterList),
        onNavigateToCharacterDetail = {},
        onNavigateToQuotes = { },
        onNavigateBack = { },
    )
}