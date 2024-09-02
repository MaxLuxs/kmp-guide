package io.maxluxs.kmp_guide

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.maxluxs.kmp_guide.features.main.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP_Guide",
    ) {
        App()
    }
}