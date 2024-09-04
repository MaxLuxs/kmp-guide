package io.maxluxs.kmp_guide.features.guide.presentation.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun GuidScreenIntroduction(
    introduction: String
) {
    Text(
        text = introduction,
        fontSize = GuideDimensions.IntroductionFontSize,
        fontWeight = FontWeight.Medium,
    )
}