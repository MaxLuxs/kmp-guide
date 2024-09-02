package io.maxluxs.kmp_guide.common

sealed interface UiState<T> {
    class Loading<T>: UiState<T>
    data class Success<T>(val data: T): UiState<T>
    data class Failed<T>(val exception: Throwable): UiState<T>
}