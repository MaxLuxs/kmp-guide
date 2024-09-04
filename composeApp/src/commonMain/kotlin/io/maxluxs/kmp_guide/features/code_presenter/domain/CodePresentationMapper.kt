package io.maxluxs.kmp_guide.features.code_presenter.domain

import io.maxluxs.kmp_guide.features.code_presenter.presentation.CodePresentation

class CodePresentationMapper {

    suspend operator fun invoke(code: String): CodePresentation {
        val lines = code.lineSequence()
            .filter { it.contains("```").not() }
            .mapIndexed { index, line -> CodePresentation.Line(index, CodePresentation.Content(line)) }
            .toList()
        return CodePresentation(CodePresentation.Lines(lines))
    }
}