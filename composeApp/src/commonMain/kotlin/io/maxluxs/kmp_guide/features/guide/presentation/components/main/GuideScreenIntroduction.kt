package io.maxluxs.kmp_guide.features.guide.presentation.components.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import io.maxluxs.kmp_guide.features.guide.presentation.components.GuideDimensions

@Composable
fun GuideScreenIntroduction(
    introduction: String
) {
    Box(
        modifier = Modifier.wrapContentHeight().fillMaxWidth(),
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            text = introduction,
            fontSize = GuideDimensions.IntroductionFontSize,
            fontWeight = FontWeight.Medium,
        )
    }
}