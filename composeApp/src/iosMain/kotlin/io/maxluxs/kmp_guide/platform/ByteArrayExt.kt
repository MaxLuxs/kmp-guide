package io.maxluxs.kmp_guide.platform

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIImage
import platform.Foundation.NSData
import platform.Foundation.create

@OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
actual fun ByteArray.toImageBitmap(): ImageBitmap {
    val nsData = NSData.create(bytes = this, length = this.size.toULong())
    val uiImage = UIImage(data = nsData)
    return uiImage.toComposeImageBitmap()
}