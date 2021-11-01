package com.app.feeds.provider.base

import androidx.lifecycle.MutableLiveData
import com.app.feeds.provider.base.Parameters

abstract class AbstractProvider(canExecute: Boolean = true) {

    private val canExecute = MutableLiveData(canExecute)

    protected fun setCanExecute(canExecute: Boolean) {
        this.canExecute.postValue(canExecute)
    }

    fun execute(params: Parameters? = null) {
        if (canExecute.value == true) {
            executeCore(params)
        }
    }

    abstract fun reset()

    protected abstract fun executeCore(params: Parameters? = null)
}