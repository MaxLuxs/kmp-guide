package io.maxluxs.kmp_guide.features.guide.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.unit.sp
import io.maxluxs.kmp_guide.common.UiState
import io.maxluxs.kmp_guide.features.guide.domain.Guide
import io.maxluxs.kmp_guide.features.guide.domain.Step
import io.maxluxs.kmp_guide.features.guide.presentation.GuideViewModel.Event
import kmp_guide.composeapp.generated.resources.Res
import kmp_guide.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.flow.collectLatest
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Preview
@Composable
fun GuideScreen(
    pathToGuide: String
) {
    val viewModel: GuideViewModel = koinViewModel()
    val state = viewModel.uiState.collectAsState()

    when(state.value) {
        is UiState.Loading -> GuidScreenProgress(state.value as UiState.Loading<Guide>)
        is UiState.Success -> GuidScreenSuccess(state.value as UiState.Success<Guide>)
        is UiState.Failed -> GuidScreenError(state.value as UiState.Failed<Guide>)
    }

    LaunchedEffect(Unit) {
        viewModel.singleEvents.collectLatest {
            when(it) {
                is Event.OnBackClicked -> {}
                is Event.OnLikeClicked -> {}
                is Event.OnAuthorClicked -> {}
            }
        }
    }
    viewModel.initGuide(pathToGuide)
}

@Composable
fun GuidScreenProgress(
    state: UiState.Loading<Guide>
) {
    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
}

@Composable
fun GuidScreenError(
    state: UiState.Failed<Guide>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Default.Warning, "Warning!")
        Text(state.exception.message ?: "Something wants wrong =(")
    }
}

@Composable
fun GuidScreenSuccess(
    state: UiState.Success<Guide>
) {
    val guide = state.data
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        guide.title?.let { item { GuidScreenTitle(it) } }
        guide.introduction?.let { item { GuidScreenIntroduction(it) } }
        GuidScreenSteps(guide.steps)
        guide.conclusion?.let { item { GuidScreenConclusion(it) } }
    }
}

val titleFontSize = 24.sp
val IntroductionFontSize = 18.sp
val conclusionFontSize = 16.sp

@Composable
fun GuidScreenTitle(
    title: String
) {
    Text(
        text = title,
        fontSize = titleFontSize,
        fontWeight = FontWeight.Bold,
        style = TextStyle(textIndent = TextIndent(50.sp, 25.sp))
    )
}

@Composable
fun GuidScreenIntroduction(
    introduction: String
) {
    Text(
        text = introduction,
        fontSize = IntroductionFontSize,
        fontWeight = FontWeight.Medium,
    )
}

fun LazyListScope.GuidScreenSteps(
    steps: List<Step>
) {
    items(steps) { step ->
        GuideScreenStep(step)
    }
}

@Composable
fun GuideScreenStep(
    step: Step
) {
    Column {
        GuideScreenStepTitle(step.title)
        Row {
            GuideScreenStepImage(step.imageUri)
            GuideScreenDescription(step.description)
        }
        GuideScreenCode(step.code)
    }
}

@Composable
fun GuideScreenCode(
    code: String?
) {
    if (!code.isNullOrEmpty()) {
        Column {
            Text("Code:")
            Text(
                text = code,
                color = Color.LightGray,
                fontSize = conclusionFontSize,
                fontWeight = FontWeight.Light,
            )
        }
    }
}

@Composable
fun GuideScreenDescription(
    description: String?
) {
    if (!description.isNullOrEmpty()) {
        Column {
            Text("description:")
            Text(
                text = description,
                color = Color.Gray,
                fontSize = conclusionFontSize,
                fontWeight = FontWeight.Light,
            )
        }
    }
}

@Composable
fun GuideScreenStepTitle(
    title: String?
) {
    if (!title.isNullOrEmpty()) {
        Column {
            Text("title:")
            Text(
                text = title,
                color = Color.Black,
                fontSize = titleFontSize,
                fontWeight = FontWeight.ExtraBold,
            )
        }
    }
}

@Composable
fun GuideScreenStepImage(
    imageUri: String?
) {
    if (!imageUri.isNullOrEmpty()) {
        Column {
            Text("imageUri:")
            Image(painterResource(Res.drawable.compose_multiplatform), null)
        }
    }
}

@Composable
fun GuidScreenConclusion(
    conclusion: String
) {
    Text(
        text = conclusion,
        fontSize = conclusionFontSize,
        fontWeight = FontWeight.Normal,
        style = TextStyle(textIndent = TextIndent(50.sp, 25.sp))
    )
}