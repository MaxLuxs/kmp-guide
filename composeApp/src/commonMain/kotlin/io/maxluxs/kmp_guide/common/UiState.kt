package io.maxluxs.kmp_guide.common

import androidx.compose.runtime.Immutable

@Immutable
sealed interface UiState<T> {
    class Loading<T>: UiState<T>
    data class Success<T>(val data: T): UiState<T>
    data class Failed<T>(val exception: Throwable): UiState<T>
}