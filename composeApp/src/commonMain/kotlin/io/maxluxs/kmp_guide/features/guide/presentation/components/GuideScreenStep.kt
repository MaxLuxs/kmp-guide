package io.maxluxs.kmp_guide.features.guide.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.maxluxs.kmp_guide.features.guide.presentation.StepUiState
import io.maxluxs.kmp_guide.platform.toImageBitmap
import org.jetbrains.compose.resources.ExperimentalResourceApi

@Composable
fun GuideScreenStep(step: StepUiState) {
    Column(
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        verticalArrangement = Arrangement.Center,
    ) {
        GuideScreenStepTitle(step.title)
        when (step) {
            is StepUiState.WithCode -> {
                Column {
                    GuideScreenStepDescription(step.description)
                    GuideScreenStepCode(step.code)
                }
            }
            is StepUiState.WithImage -> {
                Row {
                    GuideScreenStepDescription(step.description)
                    GuideScreenStepImage(step.image)
                }
            }
            is StepUiState.Simple -> GuideScreenStepDescription(step.description)
        }
    }
}

@Composable
fun GuideScreenStepTitle(title: String) {
    if (title.isNotEmpty()) {
        Box(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}

@Composable
fun GuideScreenStepImage(image: ByteArray) {
    Box(
        modifier = Modifier.padding(16.dp).wrapContentSize(),
    ) {
        Image(
            bitmap = image.toImageBitmap(),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(fraction = 0.5f)
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun GuideScreenBanner(image: ByteArray) {
    Box(
        modifier = Modifier.padding(16.dp).wrapContentSize(),
    ) {
        Image(
            bitmap = image.toImageBitmap(),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(fraction = 0.5f)
        )
    }
}

@Composable
fun GuidScreenConclusion(conclusion: String) {
    Box(
        modifier = Modifier.padding(16.dp),
    ) {
        Text(
            text = conclusion,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 8.dp),
            fontSize = GuideDimensions.conclusionFontSize,
            fontWeight = FontWeight.Normal,
            style = TextStyle(textIndent = TextIndent(50.sp, 25.sp))
        )
    }
}