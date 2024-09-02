package io.maxluxs.kmp_guide.features.main

import io.maxluxs.kmp_guide.data.GuideDataSource
import io.maxluxs.kmp_guide.features.guide.domain.GetGuideByPathUseCase
import io.maxluxs.kmp_guide.features.guide.domain.GuideRepository
import io.maxluxs.kmp_guide.features.guide.presentation.GuideViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { GuideDataSource() }
    factory { GuideRepository(get()) }
    factory { GetGuideByPathUseCase(get()) }
    viewModel { GuideViewModel(get()) }
}