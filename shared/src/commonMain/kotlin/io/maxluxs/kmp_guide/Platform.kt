package io.maxluxs.kmp_guide

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform