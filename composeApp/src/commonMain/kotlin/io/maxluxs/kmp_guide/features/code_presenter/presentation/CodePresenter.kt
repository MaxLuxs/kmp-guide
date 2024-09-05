package io.maxluxs.kmp_guide.features.code_presenter.presentation

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.maxluxs.kmp_guide.common.AppTheme
import kotlin.text.Regex.Companion.fromLiteral

val fontSize = 13.sp

@Composable
fun CodeReader(model: CodePresentation) = key(model) {
    with(LocalDensity.current) {
        SelectionContainer {
            Surface(
                Modifier.wrapContentHeight().fillMaxWidth(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Lines(model.lines)
            }
        }
    }
}

@Composable
private fun Lines(lines: CodePresentation.Lines) = with(LocalDensity.current) {
    val maxNum = remember(lines.lineNumberDigitCount) {
        (1..lines.lineNumberDigitCount).joinToString(separator = "") { "9" }
    }

    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxWidth().wrapContentHeight().horizontalScroll(rememberScrollState())) {
            lines.value.forEach { line ->
                Box(Modifier.height(Dp(fontSize.value) * 1.8f), Alignment.CenterStart) {
                    Line(Modifier.align(Alignment.CenterStart), maxNum, line)
                }
            }
        }
    }
}

fun Modifier.withoutWidthConstraints() = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints.copy(maxWidth = Int.MAX_VALUE))
    layout(constraints.maxWidth, placeable.height) {
        placeable.place(0, 0)
    }
}

@Composable
private fun Line(modifier: Modifier, maxNum: String, line: CodePresentation.Line) {
    Row(modifier = modifier) {
        DisableSelection {
            Box {
                LineNumber(maxNum, Modifier.alpha(0f))
                LineNumber(line.number.toString(), Modifier.align(Alignment.CenterEnd))
            }
        }
        LineContent(
            line.content,
            modifier = Modifier
                .weight(1f)
                .withoutWidthConstraints()
                .padding(start = 28.dp, end = 12.dp),
        )
    }
}

@Composable
private fun LineNumber(number: String, modifier: Modifier) = Text(
    text = number,
    fontSize = fontSize,
    color = LocalContentColor.current.copy(alpha = 0.30f),
    modifier = modifier.padding(start = Dp(fontSize.value))
)

@Composable
private fun LineContent(content: CodePresentation.Content, modifier: Modifier) = Text(
    text = codeString(content.value),
    fontSize = fontSize,
    maxLines = 1,
    modifier = modifier,
    softWrap = false
)

@Composable
private fun codeString(str: String) = buildAnnotatedString {
    withStyle(AppTheme.code.simple) {
        val strFormatted = str.replace("\t", "    ")
        append(strFormatted)
        addStyle(AppTheme.code.punctuation, strFormatted, ":")
        addStyle(AppTheme.code.punctuation, strFormatted, "=")
        addStyle(AppTheme.code.punctuation, strFormatted, "\"")
        addStyle(AppTheme.code.punctuation, strFormatted, "[")
        addStyle(AppTheme.code.punctuation, strFormatted, "]")
        addStyle(AppTheme.code.punctuation, strFormatted, "{")
        addStyle(AppTheme.code.punctuation, strFormatted, "}")
        addStyle(AppTheme.code.punctuation, strFormatted, "(")
        addStyle(AppTheme.code.punctuation, strFormatted, ")")
        addStyle(AppTheme.code.punctuation, strFormatted, ",")
        addStyle(AppTheme.code.keyword, strFormatted, "fun ")
        addStyle(AppTheme.code.keyword, strFormatted, "val ")
        addStyle(AppTheme.code.keyword, strFormatted, "var ")
        addStyle(AppTheme.code.keyword, strFormatted, "private ")
        addStyle(AppTheme.code.keyword, strFormatted, "internal ")
        addStyle(AppTheme.code.keyword, strFormatted, "for ")
        addStyle(AppTheme.code.keyword, strFormatted, "expect ")
        addStyle(AppTheme.code.keyword, strFormatted, "actual ")
        addStyle(AppTheme.code.keyword, strFormatted, "import ")
        addStyle(AppTheme.code.keyword, strFormatted, "package ")
        addStyle(AppTheme.code.value, strFormatted, "true")
        addStyle(AppTheme.code.value, strFormatted, "false")
        addStyle(AppTheme.code.value, strFormatted, Regex("[0-9]+"))
        addStyle(AppTheme.code.annotation, strFormatted, Regex("^@[a-zA-Z_]*"))
        addStyle(AppTheme.code.comment, strFormatted, Regex("^\\s*//.*"))
        addStyle(AppTheme.code.stringLiteral, strFormatted, Regex(""""([^"\\]*(\\.[^"\\]*)*)"""))
        append("\n")
    }
}

private fun AnnotatedString.Builder.addStyle(style: SpanStyle, text: String, regexp: String) {
    addStyle(style, text, fromLiteral(regexp))
}

private fun AnnotatedString.Builder.addStyle(style: SpanStyle, text: String, regexp: Regex) {
    for (result in regexp.findAll(text)) {
        addStyle(style, result.range.first, result.range.last + 1)
    }
}