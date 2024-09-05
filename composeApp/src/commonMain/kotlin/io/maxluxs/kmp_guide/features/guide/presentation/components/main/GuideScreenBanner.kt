package io.maxluxs.kmp_guide.features.guide.presentation.components.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.maxluxs.kmp_guide.platform.toImageBitmap

@Composable
fun GuideScreenBanner(image: ByteArray) {
    Box(
        modifier = Modifier.padding(top = 42.dp, bottom = 8.dp).wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            bitmap = image.toImageBitmap(),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(264.dp)
        )
    }
}