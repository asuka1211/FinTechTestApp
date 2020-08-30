package com.serma.fintechtestapp.presentation.hot

import com.serma.fintechtestapp.domain.usecases.GetPostsUseCase
import com.serma.fintechtestapp.presentation.base.BaseViewModel
import javax.inject.Inject

class HotViewModel @Inject constructor(
    useCase: GetPostsUseCase
) : BaseViewModel(useCase)