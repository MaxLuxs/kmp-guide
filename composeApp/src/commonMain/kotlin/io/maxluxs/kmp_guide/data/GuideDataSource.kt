package io.maxluxs.kmp_guide.data

import io.maxluxs.kmp_guide.features.guide.domain.Guide
import kmp_guide.composeapp.generated.resources.Res
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi

class GuideDataSource {

    @OptIn(ExperimentalResourceApi::class)
    suspend fun getGuideByPath(path: String): Result<Guide> {
        return try {
            val rawGuide = Res.readBytes(path).decodeToString()
            Result.success(Json.decodeFromString<Guide>(rawGuide))
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}