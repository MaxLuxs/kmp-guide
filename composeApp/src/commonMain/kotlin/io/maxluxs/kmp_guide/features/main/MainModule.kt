package io.maxluxs.kmp_guide.features.main

import io.maxluxs.kmp_guide.data.GuideDataSource
import io.maxluxs.kmp_guide.features.code_presenter.domain.CodePresentationMapper
import io.maxluxs.kmp_guide.features.guide.domain.GetGuideByPathUseCase
import io.maxluxs.kmp_guide.features.guide.domain.GuideRepositoryProtocol
import io.maxluxs.kmp_guide.features.guide.gateway.GuideRepository
import io.maxluxs.kmp_guide.features.guide.presentation.state.GuideUiStateMapper
import io.maxluxs.kmp_guide.features.guide.presentation.GuideViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { GuideDataSource() }
    factory<GuideRepositoryProtocol> { GuideRepository(get()) }
    factory { GetGuideByPathUseCase(get()) }
    factory { CodePresentationMapper() }
    factory { GuideUiStateMapper(get(), get()) }

    viewModel { GuideViewModel(get(), get()) }
}