package com.serma.fintechtestapp.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.serma.fintechtestapp.domain.entitys.Post
import com.serma.fintechtestapp.domain.usecases.GetPostsUseCase
import com.serma.fintechtestapp.data.NetworkRequestState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class BaseViewModel @Inject constructor(
    private val useCase: GetPostsUseCase
) : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()

    private val _networkState: MutableLiveData<NetworkRequestState> = MutableLiveData()
    val networkState: LiveData<NetworkRequestState> = _networkState

    private val _post: MutableLiveData<Post> = MutableLiveData()
    val post: LiveData<Post> = _post

    private val _isCanGoBack: MutableLiveData<Boolean> = MutableLiveData()
    val isCanGoBack: LiveData<Boolean> = _isCanGoBack

    fun getNext() {
        _networkState.value = NetworkRequestState.LOADING
        disposable.add(
            useCase.getNext()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturnItem(Post(networkRequestState = NetworkRequestState.ERROR))
                .subscribe { it ->
                    _post.value = it
                    _networkState.value = it.networkRequestState
                    canGoBack()
                })
    }

    fun getPrevious() {
        _post.value = useCase.getPrevious()
        canGoBack()
    }

    private fun canGoBack() {
        _isCanGoBack.value = useCase.getCurrentPost() > 0
    }

    fun getCurrentPost() {
        disposable.add(useCase.getCurrent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturnItem(Post(networkRequestState = NetworkRequestState.ERROR))
            .subscribe { it ->
                _post.value = it
                _networkState.value = it.networkRequestState
                canGoBack()
            })
    }

    fun errorLoading(){
        _networkState.value = NetworkRequestState.ERROR
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}