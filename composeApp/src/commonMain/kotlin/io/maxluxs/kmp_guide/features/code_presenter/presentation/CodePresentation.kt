package io.maxluxs.kmp_guide.features.code_presenter.presentation

import androidx.compose.runtime.Immutable

@Immutable
class CodePresentation(val lines: Lines) {

    @Immutable
    class Line(val number: Int, val content: Content)

    @Immutable
    class Lines(val value: List<Line>) {
        val lineNumberDigitCount: Int get() = size.toString().length
        val size: Int get() = value.size
        operator fun get(index: Int): Line =
            value.getOrNull(index) ?: throw IndexOutOfBoundsException()
    }

    @Immutable
    class Content(val value: String)
}