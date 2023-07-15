package com.emresahin.saymyname.quotes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.emresahin.saymyname.model.Quote
import com.emresahin.saymyname.ui.theme.Typography
import com.emresahin.saymyname.ui.theme.gradientColors

@OptIn(ExperimentalTextApi::class)
@Composable
fun QuoteListItem(
    modifier: Modifier = Modifier,
    quote: Quote,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = quote.quote,
            style = Typography.displayLarge.copy(brush = Brush.linearGradient(gradientColors)),
            textAlign = TextAlign.Center,
        )
        Text(
            text = quote.author,
            style = Typography.bodyLarge,
            textAlign = TextAlign.Center,
        )
        Text(
            text = quote.series,
            style = Typography.bodySmall,
            textAlign = TextAlign.Center,
        )
    }
}
