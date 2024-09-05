package io.maxluxs.kmp_guide.features.guide.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.maxluxs.kmp_guide.common.AppTheme
import io.maxluxs.kmp_guide.common.UiState
import io.maxluxs.kmp_guide.common.WindowSize
import io.maxluxs.kmp_guide.features.guide.presentation.components.step.GuideScreenError
import io.maxluxs.kmp_guide.features.guide.presentation.components.step.GuideScreenProgress
import io.maxluxs.kmp_guide.features.guide.presentation.components.step.GuideScreenSuccess
import io.maxluxs.kmp_guide.features.guide.presentation.state.GuideScreenUiState
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Preview
@Composable
fun GuideScreen(pathToGuide: String) {
    Surface(
        modifier = Modifier.padding(
            horizontal = when (AppTheme.windowSize) {
                WindowSize.COMPACT -> 16.dp
                WindowSize.MEDIUM -> 124.dp
                WindowSize.EXPANDED -> 264.dp
            }
        )
    ) {
        GuideScreenView(pathToGuide)
    }
}

@Composable
private fun GuideScreenView(pathToGuide: String) {
    val viewModel: GuideViewModel = koinViewModel()
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is UiState.Loading -> GuideScreenProgress(state as UiState.Loading)
        is UiState.Success -> GuideScreenSuccess(state as UiState.Success<GuideScreenUiState>)
        is UiState.Failed -> GuideScreenError(state as UiState.Failed)
    }

    LaunchedEffect(Unit) { viewModel.initGuide(pathToGuide) }
}