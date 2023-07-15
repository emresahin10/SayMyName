package com.emresahin.saymyname.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emresahin.saymyname.data.quotes.QuotesRepository
import com.emresahin.saymyname.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val quotesRepository: QuotesRepository,
) : ViewModel() {

    private val mViewState = MutableStateFlow(QuotesUiState())
    val viewState: StateFlow<QuotesUiState> = mViewState.asStateFlow()

    init {
        fetchQuotes()
    }

    private fun fetchQuotes() = viewModelScope.launch {
        quotesRepository.getQuotes().onSuccess { quotes ->
            mViewState.update { it.copy(quotes = quotes) }
        }
    }
}