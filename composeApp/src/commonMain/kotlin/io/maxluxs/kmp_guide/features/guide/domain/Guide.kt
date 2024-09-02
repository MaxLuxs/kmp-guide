package io.maxluxs.kmp_guide.features.guide.domain

import kotlinx.serialization.Serializable

@Serializable
data class Guide(
    val title: String? = null,
    val introduction: String? = null,
    val steps: List<Step> = emptyList(),
    val conclusion: String? = null
)

@Serializable
data class Step(
    val code: String? = null,
    val description: String? = null,
    val step: Int,
    val title: String? = null,
    val imageUri: String? = null
)