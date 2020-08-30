package com.serma.fintechtestapp.presentation.random

import com.serma.fintechtestapp.domain.usecases.GetPostsUseCase
import com.serma.fintechtestapp.presentation.base.BaseViewModel
import javax.inject.Inject

class RandomViewModel @Inject constructor(
    useCase: GetPostsUseCase
) : BaseViewModel(useCase)