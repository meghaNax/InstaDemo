package com.app.feeds.ui.core

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class AbstractFragment<Host, ViewBinding : ViewDataBinding>(@LayoutRes contentId: Int) : Fragment(contentId) {

    abstract val viewModel:ViewModel

    protected var hostController: Host? = null
    protected lateinit var screenBinding: ViewBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)
        hostController = context as? Host ?: throw RuntimeException("Activity should implement interface")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        screenBinding = DataBindingUtil.bind(view) ?: throw RuntimeException()
    }

    override fun onDetach() {
        super.onDetach()
        hostController = null
    }
}