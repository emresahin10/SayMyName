package com.emresahin.saymyname.character_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import com.emresahin.saymyname.ui.theme.Typography
import com.emresahin.saymyname.ui.theme.gradientColors

@OptIn(ExperimentalTextApi::class)
@Composable
internal fun CharacterDetailScreen(
    state: CharacterDetailUiState,
    onNavigateBack: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit,
            model = state.character?.img,
            contentDescription = state.character?.name
        )
        Text(
            text = state.character?.nickname.orEmpty(),
            style = Typography.displayLarge.copy(brush = Brush.linearGradient(gradientColors)),
            textAlign = TextAlign.Center,
        )
    }
}