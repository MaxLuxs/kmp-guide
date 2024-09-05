package io.maxluxs.kmp_guide.features.guide.presentation.components.step

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.maxluxs.kmp_guide.platform.toImageBitmap

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