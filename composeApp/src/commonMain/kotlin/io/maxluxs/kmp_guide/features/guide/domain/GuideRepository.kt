package io.maxluxs.kmp_guide.features.guide.domain

import io.maxluxs.kmp_guide.data.GuideDataSource

class GuideRepository(
    private val guideDataSource: GuideDataSource
) {

    suspend fun getGuideByPath(path: String): Result<Guide> {
        return guideDataSource.getGuideByPath(path)
    }
}