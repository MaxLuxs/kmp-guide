package io.maxluxs.kmp_guide.features.guide.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.maxluxs.kmp_guide.common.UiState
import io.maxluxs.kmp_guide.features.guide.presentation.GuideScreenUiState

@Composable
fun GuidScreenProgress(state: UiState.Loading<*>) {
    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
}

@Composable
fun GuidScreenError(state: UiState.Failed<*>) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Default.Warning, "Warning!")
        Text(state.exception.message ?: "Something wants wrong =(")
    }
}

@Composable
fun GuidScreenSuccess(state: UiState.Success<GuideScreenUiState>) {
    val guide = state.data
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {}
        item { GuidScreenTitle(guide.title) }
        item { GuidScreenIntroduction(guide.introduction) }
        items(items = guide.steps, key = { it.step }) {
            step -> GuideScreenStep(step)
        }
        item { GuidScreenConclusion(guide.conclusion) }
    }
}