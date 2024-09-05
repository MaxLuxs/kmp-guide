package io.maxluxs.kmp_guide.features.guide.presentation.state

import androidx.compose.runtime.Immutable
import io.maxluxs.kmp_guide.features.code_presenter.presentation.CodePresentation

@Immutable
data class GuideScreenUiState(
    val banner: ByteArray,
    val title: String,
    val introduction: String,
    val steps: List<StepUiState>,
    val conclusion: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as GuideScreenUiState

        if (!banner.contentEquals(other.banner)) return false
        if (title != other.title) return false
        if (introduction != other.introduction) return false
        if (steps != other.steps) return false
        if (conclusion != other.conclusion) return false

        return true
    }

    override fun hashCode(): Int {
        var result = banner.contentHashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + introduction.hashCode()
        result = 31 * result + steps.hashCode()
        result = 31 * result + conclusion.hashCode()
        return result
    }
}

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
    ): StepUiState(step, title, description) {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as WithImage

            if (step != other.step) return false
            if (title != other.title) return false
            if (description != other.description) return false
            if (!image.contentEquals(other.image)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = step
            result = 31 * result + title.hashCode()
            result = 31 * result + description.hashCode()
            result = 31 * result + image.contentHashCode()
            return result
        }
    }

    data class WithCode(
        override val step: Int,
        override val title: String,
        override val description: String,
        val code: CodePresentation
    ): StepUiState(step, title, description)
}