package com.serma.fintechtestapp.presentation.best

import com.serma.fintechtestapp.domain.usecases.GetPostsUseCase
import com.serma.fintechtestapp.presentation.base.BaseViewModel
import javax.inject.Inject

class BestViewModel @Inject constructor(
    useCase: GetPostsUseCase
) : BaseViewModel(useCase)