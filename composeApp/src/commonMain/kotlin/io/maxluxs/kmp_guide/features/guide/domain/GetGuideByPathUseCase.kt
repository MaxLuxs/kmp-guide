package io.maxluxs.kmp_guide.features.guide.domain

class GetGuideByPathUseCase(
    private val guideRepository: GuideRepository
) {
    suspend operator fun invoke(path: String): Result<Guide> {
        return guideRepository.getGuideByPath(path)
    }
}