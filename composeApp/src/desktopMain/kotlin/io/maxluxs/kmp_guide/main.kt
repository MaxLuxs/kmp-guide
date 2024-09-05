package io.maxluxs.kmp_guide

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import io.maxluxs.kmp_guide.common.WindowSize
import io.maxluxs.kmp_guide.features.main.App

fun main() = application {
    val windowState = rememberWindowState(size = DpSize(1280.dp, 720.dp))
    Window(
        state = windowState,
        onCloseRequest = ::exitApplication,
        title = "KMP_Guide",
    ) {
        App(WindowSize.basedOnWidth(windowState.size.width))
    }
}