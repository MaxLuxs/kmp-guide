package io.maxluxs.kmp_guide.platform

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import org.jetbrains.skia.Image

actual fun ByteArray.toImageBitmap(): ImageBitmap {
    val image = Image.makeFromEncoded(this)
    return image.toComposeImageBitmap()
}