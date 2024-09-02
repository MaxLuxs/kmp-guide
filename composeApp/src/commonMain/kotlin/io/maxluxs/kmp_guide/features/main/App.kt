package io.maxluxs.kmp_guide.features.main

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import io.maxluxs.kmp_guide.features.guide.presentation.GuideScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.dsl.koinApplication

fun koinConfiguration() = koinApplication {
    modules(appModule)
}

@Composable
@Preview
fun App() {
    KoinApplication(::koinConfiguration) {
        MaterialTheme {
            GuideScreen("files/how_start_kmp_guide/how_start_kmp_ru.json")
        }
    }
}