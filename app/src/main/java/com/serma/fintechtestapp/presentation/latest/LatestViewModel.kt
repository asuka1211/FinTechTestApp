package com.serma.fintechtestapp.presentation.latest

import com.serma.fintechtestapp.domain.usecases.GetPostsUseCase
import com.serma.fintechtestapp.presentation.base.BaseViewModel
import javax.inject.Inject

class LatestViewModel @Inject constructor(
    useCase: GetPostsUseCase
) : BaseViewModel(useCase)
