package io.maxluxs.kmp_guide.features.guide.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun GuideScreenStepDescription(
    description: String
) {
    if (description.isNotEmpty()) {
        Column(
            modifier = Modifier.wrapContentHeight(),
            verticalArrangement = Arrangement.Center,
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
