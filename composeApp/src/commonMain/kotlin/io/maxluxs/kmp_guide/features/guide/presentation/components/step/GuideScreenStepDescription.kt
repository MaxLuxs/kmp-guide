package io.maxluxs.kmp_guide.features.guide.presentation.components.step

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.maxluxs.kmp_guide.features.guide.presentation.components.GuideDimensions

@Composable
fun GuideScreenStepDescription(
    description: String
) {
    if (description.isNotEmpty()) {
        Box(
            modifier = Modifier.padding(vertical = 4.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.CenterStart,
        ) {
            Text(
                text = description,
                color = Color.Gray,
                fontSize = GuideDimensions.conclusionFontSize,
                fontWeight = FontWeight.Light,
            )
        }
    }
}
