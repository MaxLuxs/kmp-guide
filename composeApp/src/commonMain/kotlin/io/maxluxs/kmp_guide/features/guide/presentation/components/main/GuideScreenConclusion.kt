package io.maxluxs.kmp_guide.features.guide.presentation.components.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.maxluxs.kmp_guide.features.guide.presentation.components.GuideDimensions

@Composable
fun GuideScreenConclusion(conclusion: String) {
    Box(
        modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(bottom = 42.dp),
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(
            text = conclusion,
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            fontSize = GuideDimensions.conclusionFontSize,
            fontWeight = FontWeight.ExtraBold,
        )
    }
}