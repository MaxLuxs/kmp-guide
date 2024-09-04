package io.maxluxs.kmp_guide.features.guide.domain

interface GuideRepositoryProtocol {

    suspend fun getGuideByPath(path: String): Result<Guide>
}