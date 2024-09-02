package io.maxluxs.kmp_guide.features.guide.presentation

data class GuideScreenState(
    val title: String,
    val entities: List<GuideEntity>
)

sealed interface GuideEntity {
    data class Header(val text: String): GuideEntity
    data class Text(val text: String): GuideEntity
    data class Image(val uri: String): GuideEntity
    data class Mark(val text: String): GuideEntity
}