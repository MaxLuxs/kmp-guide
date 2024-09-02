package io.maxluxs.kmp_guide.features.guide.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.maxluxs.kmp_guide.common.UiState
import io.maxluxs.kmp_guide.features.guide.domain.GetGuideByPathUseCase
import io.maxluxs.kmp_guide.features.guide.domain.Guide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

 class GuideViewModel(
    private val getGuideByPathUseCase: GetGuideByPathUseCase
): ViewModel() {

     sealed interface Event {
         data object OnBackClicked: Event
         data object OnLikeClicked: Event
         data object OnAuthorClicked: Event
     }

     private val _uiState = MutableStateFlow<UiState<Guide>>(emptyState())
     val uiState: StateFlow<UiState<Guide>> = _uiState

     private val singleEventsChannel = Channel<Event>(Channel.BUFFERED)
     val singleEvents: Flow<Event>
         get() = singleEventsChannel.receiveAsFlow()

     fun initGuide(pathToGuide: String) {
        viewModelScope.launch(Dispatchers.Default) {
            _uiState.emit(UiState.Loading())
            val result = getGuideByPathUseCase(pathToGuide)
            withContext(Dispatchers.Main) {
                result.fold(
                    onSuccess = { _uiState.emit(UiState.Success(it)) },
                    onFailure = {  _uiState.emit(UiState.Failed(it)) }
                )
            }
        }
    }

     fun onEvent(event: Event) {
         viewModelScope.launch {
             singleEventsChannel.send(event)
         }
     }

    private fun emptyState() = UiState.Loading<Guide>()

}