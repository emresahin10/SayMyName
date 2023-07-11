package com.emresahin.saymyname.character_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@Composable
internal fun CharacterDetailScreen(
    state: CharacterDetailUiState,
    onNavigateBack: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit,
            model = state.character?.img,
            contentDescription = state.character?.name
        )
    }
}