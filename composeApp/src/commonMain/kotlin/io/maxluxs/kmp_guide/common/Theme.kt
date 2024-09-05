package io.maxluxs.kmp_guide.common

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle

@Immutable
data class Theme(
    val materialColors: ColorScheme,
    val colors: ExtendedColors,
    val code: CodeStyle,
    val windowSize: WindowSize,
) {
    @Immutable
    class ExtendedColors(
        val codeGuide: Color
    )

    @Immutable
    data class CodeStyle(
        val simple: SpanStyle,
        val value: SpanStyle,
        val keyword: SpanStyle,
        val punctuation: SpanStyle,
        val annotation: SpanStyle,
        val comment: SpanStyle,
        val stringLiteral: SpanStyle
    )

    companion object {
        fun dark(windowSize: WindowSize) = Theme(
            materialColors = darkColorScheme(
                background = Color(0xFF2B2B2B),
                surface = Color(0xFF3C3F41)
            ),
            colors = ExtendedColors(
                codeGuide = Color(0xFF4E5254)
            ),
            code = CodeStyle(
                simple = SpanStyle(Color(0xFFA9B7C6)),
                value = SpanStyle(Color(0xFF6897BB)),
                keyword = SpanStyle(Color(0xFFCC7832)),
                punctuation = SpanStyle(Color(0xFFA1A1A1)),
                annotation = SpanStyle(Color(0xFFBBB529)),
                comment = SpanStyle(Color(0xFF808080)),
                stringLiteral = SpanStyle(Color(0xFF92b975)),
            ),
            windowSize = windowSize
        )

        fun light(windowSize: WindowSize) = Theme(
            materialColors = lightColorScheme(
                background = Color(0xFFF5F5F5),
                surface = Color(0xFFFFFFFF)
            ),
            colors = ExtendedColors(
                codeGuide = Color(0xFF8E9294)
            ),
            code = CodeStyle(
                simple = SpanStyle(Color(0xFF000000)),
                value = SpanStyle(Color(0xFF4A86E8)),
                keyword = SpanStyle(Color(0xFF000080)),
                punctuation = SpanStyle(Color(0xFFA1A1A1)),
                annotation = SpanStyle(Color(0xFFBBB529)),
                comment = SpanStyle(Color(0xFF808080)),
                stringLiteral = SpanStyle(Color(0xFF92b975))
            ),
            windowSize = windowSize
        )
    }
}

val LocalTheme = staticCompositionLocalOf { Theme.dark(WindowSize.COMPACT) }

val LocalWindowSize = staticCompositionLocalOf { WindowSize.COMPACT }

val AppTheme
    @Composable
    get() = LocalTheme.current

val AppWindowSize
    @Composable
    get() = LocalWindowSize.current