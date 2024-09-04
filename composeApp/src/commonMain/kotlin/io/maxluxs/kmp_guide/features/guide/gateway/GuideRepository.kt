package io.maxluxs.kmp_guide.features.guide.gateway

import io.maxluxs.kmp_guide.data.GuideDataSource
import io.maxluxs.kmp_guide.features.guide.domain.Guide
import io.maxluxs.kmp_guide.features.guide.domain.GuideRepositoryProtocol

class GuideRepository(
    private val guideDataSource: GuideDataSource
): GuideRepositoryProtocol {

    override suspend fun getGuideByPath(path: String): Result<Guide> {
        return guideDataSource.getGuideByPath(path)
    }
}