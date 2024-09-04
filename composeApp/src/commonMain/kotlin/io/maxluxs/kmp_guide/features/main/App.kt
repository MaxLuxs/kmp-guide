package io.maxluxs.kmp_guide.features.main

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import io.maxluxs.kmp_guide.common.LocalTheme
import io.maxluxs.kmp_guide.common.LocalWindowSize
import io.maxluxs.kmp_guide.common.Theme
import io.maxluxs.kmp_guide.common.WindowSize
import io.maxluxs.kmp_guide.features.guide.presentation.GuideScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.dsl.koinApplication

fun koinConfiguration() = koinApplication {
    modules(appModule)
}

@Composable
@Preview
fun App(windowSize: WindowSize = WindowSize.MEDIUM) {
    KoinApplication(::koinConfiguration) {
        DisableSelection {
            val theme = if (isSystemInDarkTheme()) Theme.dark(windowSize) else Theme.light(windowSize)

            CompositionLocalProvider(
                LocalTheme provides theme,
                LocalWindowSize provides windowSize
            ) {
                MaterialTheme(colors = theme.materialColors) {
                    Surface {
                        GuideScreen("files/guides/how_start_kmp_guide/how_start_kmp_ru.json")
                    }
                }
            }
        }
    }
}