package io.maxluxs.kmp_guide.features.guide.presentation

import io.maxluxs.kmp_guide.data.GuideDataSource
import io.maxluxs.kmp_guide.features.code_presenter.domain.CodePresentationMapper
import io.maxluxs.kmp_guide.features.guide.domain.Guide
import io.maxluxs.kmp_guide.features.guide.domain.Step

class GuideUiStateMapper(
    private val guideDataSource: GuideDataSource,
    private val codePresentationMapper: CodePresentationMapper
) {

    suspend operator fun invoke(guide: Guide): GuideScreenUiState {
        val bannerBytes = guideDataSource.getImageByName(guide.banner ?: DEFAULT_BANNER)
            .getOrNull() ?: error("banner not found")
        return GuideScreenUiState(
            banner = bannerBytes,
            title = guide.title ?: "",
            introduction = guide.introduction ?: "",
            steps = mapSteps(guide.steps),
            conclusion = guide.conclusion ?: ""
        )
    }

    private suspend fun mapSteps(steps: List<Step>): List<StepUiState> {
        return steps.map { mapStep(it) }
    }

    private suspend fun mapStep(step: Step): StepUiState {
        val imageBytes = step.imageUri?.let {
            guideDataSource.getImageByName(it).getOrNull()
        }
        return when {
            step.code != null -> StepUiState.WithCode(
                step = step.step,
                title = step.title ?: "",
                description = step.description ?: "",
                code = codePresentationMapper(step.code)
            )

            imageBytes != null -> StepUiState.WithImage(
                step = step.step,
                title = step.title ?: "",
                description = step.description ?: "",
                image = imageBytes
            )

            else -> StepUiState.Simple(
                step = step.step,
                title = step.title ?: "",
                description = step.description ?: "",
            )
        }
    }

    companion object {
        private const val DEFAULT_BANNER = "compose_banner.jpeg"
    }
}