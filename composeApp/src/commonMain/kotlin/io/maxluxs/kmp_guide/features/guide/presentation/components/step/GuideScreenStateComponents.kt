package io.maxluxs.kmp_guide.features.guide.presentation.components.step

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.maxluxs.kmp_guide.common.UiState
import io.maxluxs.kmp_guide.features.guide.presentation.components.main.GuideScreenBanner
import io.maxluxs.kmp_guide.features.guide.presentation.components.main.GuideScreenConclusion
import io.maxluxs.kmp_guide.features.guide.presentation.components.main.GuideScreenIntroduction
import io.maxluxs.kmp_guide.features.guide.presentation.components.main.GuideScreenTitle
import io.maxluxs.kmp_guide.features.guide.presentation.state.GuideScreenUiState

@Composable
fun GuideScreenProgress(state: UiState.Loading<*>) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun GuideScreenError(state: UiState.Failed<*>) {
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
fun GuideScreenSuccess(state: UiState.Success<GuideScreenUiState>) {
    val guide = state.data
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item { GuideScreenBanner(guide.banner) }
        item { GuideScreenTitle(guide.title) }
        item { GuideScreenIntroduction(guide.introduction) }
        items(items = guide.steps, key = { it.step }) { step ->
            GuideScreenStep(step)
        }
        item { GuideScreenConclusion(guide.conclusion) }
    }
}