package com.app.feeds.provider.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class AsyncProvider : AbstractProvider() {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.IO
    internal val scope = CoroutineScope(coroutineContext)

    val asyncState = MutableLiveData(State.IDLE)

    protected val _loadError = MutableLiveData<Throwable>()
    val loadError: LiveData<Throwable> = _loadError

    fun isProcessing() = asyncState.value == State.BUSY

    override fun reset() {
        _loadError.value = null
    }

    protected open fun setState(state: State) {
        asyncState.postValue(state)
        when (state) {
            State.BUSY -> setCanExecute(false)
            State.FINISHED -> setCanExecute(true)
            State.FAILED -> setCanExecute(true)
            State.IDLE -> setCanExecute(true)
            State.CLEARED -> setCanExecute(true)
        }
    }

    enum class State {
        IDLE,
        BUSY,
        FINISHED,
        FAILED,
        CLEARED
    }
}