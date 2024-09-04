package io.maxluxs.kmp_guide.features.guide.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GuidScreenTitle(
    title: String
) {
    Text(
        text = title,
        modifier = Modifier.fillMaxWidth().padding(12.dp),
        fontSize = GuideDimensions.titleFontSize,
        fontWeight = FontWeight.Bold,
        style = TextStyle(textIndent = TextIndent(50.sp, 25.sp))
    )
}