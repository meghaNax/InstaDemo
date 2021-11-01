package com.app.feeds.ui.ext

import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target


@BindingAdapter("circleImage", "placeholder", requireAll = false)
fun ImageView.bindCircleImage(image: String?, placeholder: Drawable?) {
    Log.d("TEST_URL_1",image)
    if (image.isNullOrEmpty()) {
        if (placeholder != null) {
            setImageDrawable(placeholder)
        } else {
            setImageDrawable(null)
        }
    } else {

        Glide.with(context)
            .load(Uri.parse(image))
            .placeholder(placeholder)
            .error(placeholder)
            .override(500)
            .into(this)
    }
}

@BindingAdapter("isSelected")
fun View.bindIsSelected(selected: Boolean) {
    isSelected = selected
}