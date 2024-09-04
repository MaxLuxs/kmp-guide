package io.maxluxs.kmp_guide.features.guide.presentation

import androidx.compose.runtime.Immutable
import io.maxluxs.kmp_guide.features.code_presenter.presentation.CodePresentation

@Immutable
data class GuideScreenUiState(
    val banner: ByteArray,
    val title: String,
    val introduction: String,
    val steps: List<StepUiState>,
    val conclusion: String
)

@Immutable
sealed class StepUiState(
    open val step: Int,
    open val title: String,
    open val description: String
) {

    data class Simple(
        override val step: Int,
        override val title: String,
        override val description: String,
    ): StepUiState(step, title, description)

    data class WithImage(
        override val step: Int,
        override val title: String,
        override val description: String,
        val image: ByteArray
    ): StepUiState(step, title, description)

    data class WithCode(
        override val step: Int,
        override val title: String,
        override val description: String,
        val code: CodePresentation
    ): StepUiState(step, title, description)
}