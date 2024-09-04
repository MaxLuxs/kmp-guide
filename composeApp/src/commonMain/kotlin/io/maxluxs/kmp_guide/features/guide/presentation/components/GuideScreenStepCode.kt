package io.maxluxs.kmp_guide.features.guide.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.maxluxs.kmp_guide.features.code_presenter.presentation.CodePresentation
import io.maxluxs.kmp_guide.features.code_presenter.presentation.CodeReader

@Composable
fun GuideScreenStepCode(code: CodePresentation) {
    Card(
        modifier = Modifier.padding(16.dp),
        elevation = 0.dp
    ) {
        CodeReader(code)
    }
}