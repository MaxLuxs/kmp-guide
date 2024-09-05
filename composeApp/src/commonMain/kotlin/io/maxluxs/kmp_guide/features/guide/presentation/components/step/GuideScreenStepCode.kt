package io.maxluxs.kmp_guide.features.guide.presentation.components.step

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.maxluxs.kmp_guide.features.code_presenter.presentation.CodePresentation
import io.maxluxs.kmp_guide.features.code_presenter.presentation.CodeReader

@Composable
fun GuideScreenStepCode(code: CodePresentation) {
    Card(
        modifier = Modifier.padding(vertical = 8.dp),
        border = BorderStroke(1.dp, Color.Gray),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        CodeReader(code)
    }
}