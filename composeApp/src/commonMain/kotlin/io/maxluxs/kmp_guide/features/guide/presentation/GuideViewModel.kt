package io.maxluxs.kmp_guide.features.guide.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.maxluxs.kmp_guide.common.UiState
import io.maxluxs.kmp_guide.features.guide.domain.GetGuideByPathUseCase
import io.maxluxs.kmp_guide.features.guide.presentation.state.GuideScreenUiState
import io.maxluxs.kmp_guide.features.guide.presentation.state.GuideUiStateMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GuideViewModel(
    private val getGuideByPathUseCase: GetGuideByPathUseCase,
    private val guideUiStateMapper: GuideUiStateMapper,
): ViewModel() {

     sealed interface Event {
         data object OnBackClicked: Event
         data object OnLikeClicked: Event
         data object OnAuthorClicked: Event
     }

     private val _uiState = MutableStateFlow<UiState<GuideScreenUiState>>(emptyState())
     val uiState: StateFlow<UiState<GuideScreenUiState>> = _uiState

     fun initGuide(pathToGuide: String) {
        viewModelScope.launch(Dispatchers.Default) {
            _uiState.emit(UiState.Loading())
            getGuideByPathUseCase(pathToGuide).fold(
                onSuccess = {
                    val uiState = guideUiStateMapper(it)
                    withContext(Dispatchers.Main) {
                        _uiState.emit(UiState.Success(uiState))
                    }
                },
                onFailure = {
                    withContext(Dispatchers.Main) {
                        _uiState.emit(UiState.Failed(it))
                    }
                }
            )
        }
    }

     fun onEvent(event: Event) {
         viewModelScope.launch {

         }
     }

    private fun emptyState() = UiState.Loading<GuideScreenUiState>()

}