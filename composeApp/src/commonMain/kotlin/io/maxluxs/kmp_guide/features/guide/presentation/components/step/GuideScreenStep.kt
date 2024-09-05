package io.maxluxs.kmp_guide.features.guide.presentation.components.step

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.maxluxs.kmp_guide.features.guide.presentation.StepUiState

@Composable
fun GuideScreenStep(step: StepUiState) {
    Box(
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        contentAlignment = Alignment.Center,
    ) {
        when (step) {
            is StepUiState.WithCode -> {
                Column {
                    GuideScreenStepTitle(step.title)
                    GuideScreenStepDescription(step.description)
                    GuideScreenStepCode(step.code)
                }
            }
            is StepUiState.WithImage -> {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    GuideScreenStepImage(step.image)
                    Column {
                        GuideScreenStepTitle(step.title)
                        GuideScreenStepDescription(step.description)
                    }
                }
            }
            is StepUiState.Simple -> {
                Column {
                    GuideScreenStepTitle(step.title)
                    GuideScreenStepDescription(step.description)
                }
            }
        }
    }
}