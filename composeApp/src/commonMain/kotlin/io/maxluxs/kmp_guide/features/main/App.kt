package io.maxluxs.kmp_guide.features.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.maxluxs.kmp_guide.common.LocalTheme
import io.maxluxs.kmp_guide.common.LocalWindowSize
import io.maxluxs.kmp_guide.common.Theme
import io.maxluxs.kmp_guide.common.WindowSize
import io.maxluxs.kmp_guide.features.guide.gateway.Guides
import io.maxluxs.kmp_guide.features.guide.presentation.GuideScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.dsl.koinApplication

fun koinConfiguration() = koinApplication {
    modules(appModule)
}

@OptIn(ExperimentalMaterial3Api::class)
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
                MaterialTheme(colorScheme = theme.materialColors) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                navigationIcon = {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "Back",
                                        modifier = Modifier.padding(start = 16.dp)
                                            .clickable {

                                            }
                                    )
                                },
                                title = {
                                    Text("Title")
                                }
                            )
                        },
                        bottomBar = {
                            if (windowSize == WindowSize.COMPACT) {
                                BottomAppBar {
                                    Text("Bottom")
                                }
                            }
                        }
                    ) {
                        Surface(Modifier.padding(it)) {
                            GuideScreen(Guides.HOW_START)
                        }
                    }
                }
            }
        }
    }
}