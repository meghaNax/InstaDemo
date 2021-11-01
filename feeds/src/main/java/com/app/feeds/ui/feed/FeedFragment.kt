package com.app.feeds.ui.feed

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.core.app.ShareCompat
import androidx.recyclerview.widget.SimpleItemAnimator
import com.app.feeds.R
import com.app.feeds.databinding.FragmentTrimideasBinding
import com.app.feeds.ui.core.AbstractFragment
import com.app.feeds.ui.feed.core.adapter.FeedAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class FeedFragment :
    AbstractFragment<Activity, FragmentTrimideasBinding>(contentId = R.layout.fragment_trimideas) {

    override val viewModel: FeedViewModel by viewModel()


    val adapter by lazy {
        FeedAdapter()
            .also {
                it.onBookMarkClick = {
                    viewModel.bookMarkedItem(it)
                }
                it.onLikeClick = {
                    viewModel.likeItem(it)
                }
                it.onShareClick = { feedItem ->
                    feedItem.message.share(requireActivity())
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        screenBinding.lifecycleOwner = this
        screenBinding.viewModel = viewModel
        (screenBinding.feedRecyclerView.itemAnimator as SimpleItemAnimator).supportsChangeAnimations =
            false
        screenBinding.feedRecyclerView.adapter = adapter
        viewModel.feed.observe(viewLifecycleOwner) {
            adapter.setContent(it)
        }
    }

}

fun String.share(activity: Activity) {
    val mimeType = "text/plain"
    val shareIntent = ShareCompat.IntentBuilder(activity)
        .setType(mimeType)
        .setText(this)
        .intent
    try {
        if (shareIntent.resolveActivity(activity.packageManager) != null) {
            activity.startActivity(shareIntent)
        }
    } catch (ex: Throwable) {
        ex.printStackTrace()
    }
}